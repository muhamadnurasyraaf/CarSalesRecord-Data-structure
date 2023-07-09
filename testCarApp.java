import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class testCarApp {
    public static void main(String[] args) {
        LinkedList localList = new LinkedList();
        LinkedList importList = new LinkedList();
        Car c;
        try {
            FileReader fr = new FileReader("carData.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;

            while((line = br.readLine()) != null){
                StringTokenizer st = new StringTokenizer(line,",");
                String regNum = st.nextToken();
                String model = st.nextToken();
                double netPrice = Double.parseDouble(st.nextToken());
                char channel = st.nextToken().charAt(0);
                if(channel == 'L' || channel == 'l'){
                    String date = st.nextToken();
                    String state = st.nextToken();
                    c = new Local(regNum, model, netPrice, date, state);
                    localList.insertAtBack(c);
                }else if(channel == 'I' || channel == 'i'){
                    String id = st.nextToken();
                    String country = st.nextToken();
                    double tax = Double.parseDouble(st.nextToken());
                    c = new Imported(regNum, model, netPrice, id, country, tax);
                    importList.insertAtFront(c);
                }
            }
            br.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

          Queue tempList = new Queue();

        JOptionPane.showMessageDialog(null, "**********WELCOME to CAR MOLEKZ SALES RECORD SYSTEM**********");
        int option = Integer.parseInt(JOptionPane.showInputDialog("Please Enter any number to use these features : [1]List All The Sold Cars Details | [2]Search a Car Detail | [3]Edit a Car Detail | [4]Delete a sold car detail"));

        if(option == 1){
            int opt = Integer.parseInt(JOptionPane.showInputDialog("[1]Imported Car or [2]Local Car or [3]Both?"));
            if(opt == 1){
               //first queue implementation
                while(!importList.isEmpty()){
                    Car temp = (Car) importList.removeFront();
                    System.out.println(temp.toString());
                    tempList.enqueue(temp);
                }
                while(!tempList.isEmpty()){
                    Car temp = tempList.dequeue();
                    importList.insertAtFront(temp);
                }
            }else if(opt == 2){
                Car temp;
                while(!localList.isEmpty()){
                     temp = localList.removeFront();
                    System.out.println(temp.toString());
                    tempList.enqueue(temp);
                }

                while(!tempList.isEmpty()){
                    temp = tempList.dequeue();
                    localList.insertAtFront(temp);
                }
            }else if(opt == 3){

            }
        }
    }
}
