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
                StringTokenizer st = new StringTokenizer(line,";");
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
                    importList.insertAtBack(c);
                }
            }
            br.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

          Queue tempList = new Queue();

        JOptionPane.showMessageDialog(null, "**********WELCOME to CAR MOLEKZ SALES RECORD SYSTEM**********");
        int option = Integer.parseInt(JOptionPane.showInputDialog("Please Enter any number to use these features : [1]List All The Sold Cars Details | [2]Search a Car Detail | [3]Edit a Car Detail | [4]Delete a sold car detail"));
        char input;
        do {
            if(option == 1){
            int opt = Integer.parseInt(JOptionPane.showInputDialog("[1]Imported Car or [2]Local Car or [3]Both?"));
            if(opt == 1){
               //first queue implementation
                System.out.println("List of Imported Cars : \n" );
                while(!importList.isEmpty()){
                    Car temp = (Car) importList.removeFront();
                    System.out.println(temp.toString());
                    System.out.println("\n");
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

                //displaying imported cars
                System.out.println("List of Imported Cars : \n" );
                while(!importList.isEmpty()){
                    Car temp = (Car) importList.removeFront();
                    System.out.println(temp.toString());
                    tempList.enqueue(temp);
                }
                while(!tempList.isEmpty()){
                    Car temp = (Car) tempList.dequeue();
                    importList.insertAtBack(temp);
                }

                //displaying local cars
                System.out.println("List of Local Cars : \n");
                while(!localList.isEmpty()){
                    Car temp = (Car) localList.removeFront();
                    System.out.println(temp.toString());
                    tempList.enqueue(temp);
                }

                while(!tempList.isEmpty()){
                    Car temp = (Car) tempList.dequeue();
                    localList.insertAtBack(temp);
                }
            }
            }else if(option == 2){
                int opt = Integer.parseInt(JOptionPane.showInputDialog("Imported[1] or Local[2] ?"));
                String regNum = JOptionPane.showInputDialog("Enter the car registration Number: ");

                if(opt == 1){
                    while(!importList.isEmpty()){
                        Car temp = (Car) importList.removeFront();
                        if(temp.getRegNum().equalsIgnoreCase(regNum)){
                            System.out.println(temp.toString());
                        }
                        tempList.enqueue(temp);
                    }
                    while(!tempList.isEmpty()){
                        Car temp = (Car) tempList.dequeue();
                        importList.insertAtBack(temp);
                    }
                }else if(opt == 2){
                    while(!localList.isEmpty()){
                        Car temp = (Car) localList.removeFront();
                        if(temp.getRegNum().equalsIgnoreCase(regNum)){
                            System.out.println(temp.toString());
                        }
                        tempList.enqueue(temp);
                    }
                    while(!tempList.isEmpty()){
                        Car temp = (Car) tempList.dequeue();
                    localList.insertAtBack(temp);
                    }
                }else{
                    System.out.println("Invalid Input");
                }

            }else if(option == 3){
                  int opt = Integer.parseInt(JOptionPane.showInputDialog("Imported[1] or Local[2] ?"));
                String regNum = JOptionPane.showInputDialog("Enter the car registration Number: ");

                if(opt == 1){
                    while(!importList.isEmpty()){
                        Imported temp = (Imported) importList.removeFront();
                        if(temp.getRegNum().equalsIgnoreCase(regNum)){
                            System.out.println(temp.toString());
                            int opti = Integer.parseInt(JOptionPane.showInputDialog("Which details you want to edit[1-Registration Number|2-Model|3-Net Price|4-Import Id|5-Country|6-Import Tax]"));
                            if(opti == 1){
                                String newRegNum = JOptionPane.showInputDialog("Enter new registration number");
                                temp.setRegNum(newRegNum);
                                System.out.println("Updated Data : ");
                                System.out.println(temp.toString());
                            }else if(opti == 2){
                                String newModel = JOptionPane.showInputDialog("Enter new model ");
                                temp.setModel(newModel);
                                System.out.println("Updated Data : ");
                                System.out.println(temp.toString());
                            }else if(opti == 3){
                                double newNetPrice = Double.parseDouble(JOptionPane.showInputDialog("Enter new net price"));
                                temp.setNetPrice(newNetPrice);
                                System.out.println("Updated Data : ");
                                System.out.println(temp.toString());
                            }else if(opti == 4){
                                String newImportId = JOptionPane.showInputDialog("Enter new Import Id");
                                temp.setImportId(newImportId);
                                System.out.println("Updated Data : ");
                                System.out.println(temp.toString());
                            }else if(opti == 5){
                                String country = JOptionPane.showInputDialog("Enter new country");
                                temp.setCountry(country);
                                System.out.println("Updated Data : ");
                                System.out.println(temp.toString());
                            }else if(opti == 6){
                                double newimportTax = Double.parseDouble(JOptionPane.showInputDialog("Enter new Import Tax"));
                                temp.setImportTax(newimportTax);
                                System.out.println("Updated Data : ");
                                System.out.println(temp.toString());
                            }else{
                                JOptionPane.showMessageDialog(null,"Invalid Input");
                            }
                        }
                        tempList.enqueue(temp);
                    }
                    while(!tempList.isEmpty()){ 
                        Imported temp = (Imported) tempList.dequeue();
                        importList.insertAtBack(temp);
                    }
                    //end of imported
                }else if(opt == 2){
                    while(!localList.isEmpty()){
                        Local temp = (Local) localList.removeFront();
                        if(temp.getRegNum().equalsIgnoreCase(regNum)){
                            System.out.println(temp.toString());
                            int opti = Integer.parseInt(JOptionPane.showInputDialog("Which details you want to edit[1-Registration Number|2-Model|3-Net Price|4-Manufacturing Date|5-Manufacturing State]"));
                            if(opti == 1){
                                String newRegNum = JOptionPane.showInputDialog("Enter new registration number");
                                temp.setRegNum(newRegNum);
                                System.out.println("Updated Data : ");
                                System.out.println(temp.toString());
                            }else if(opti == 2){
                                String newModel = JOptionPane.showInputDialog("Enter new model ");
                                temp.setModel(newModel);
                                System.out.println("Updated Data : ");
                                System.out.println(temp.toString());
                            }else if(opti == 3){
                                double newNetPrice = Double.parseDouble(JOptionPane.showInputDialog("Enter new net price"));
                                temp.setNetPrice(newNetPrice);
                                System.out.println("Updated Data : ");
                                System.out.println(temp.toString());
                            }else if(opti == 4){
                                String newManDate = JOptionPane.showInputDialog("Enter new manufacturing date");
                                temp.setManufacturedDate(newManDate);
                                System.out.println("Updated Data : ");
                                System.out.println(temp.toString());
                            }else if(opti == 5){
                                String newManState = JOptionPane.showInputDialog("Enter new manufacturing state ");
                                temp.setManufacturedState(newManState);
                                System.out.println("Updated Data : ");
                                System.out.println(temp.toString());
                            }else{
                                JOptionPane.showMessageDialog(null,"Invalid Input");
                            }

                        }
                        tempList.enqueue(temp);
                    }
                    while(!tempList.isEmpty()){
                        Local temp = (Local) tempList.dequeue();
                        localList.insertAtBack(temp);
                    }
                }else{
                    System.out.println("Invalid Input");
                }
            }else if(option == 4){
                 int opt = Integer.parseInt(JOptionPane.showInputDialog("[1]Imported Car or [2]Local Car or [3]Both?"));
                String regNum = JOptionPane.showInputDialog("Enter the car registration Number: ");

                if(opt == 1){
                    while(!importList.isEmpty()){
                        Car temp = (Car) importList.removeFront();
                        if(temp.getRegNum().equalsIgnoreCase(regNum)){
                            System.out.println("Car data to delete .. ");
                            System.out.println(temp.toString());
                        }
                    }
                   
                }else if(opt == 2){
                    while(!localList.isEmpty()){
                        Car temp = (Car) localList.removeFront();
                        if(temp.getRegNum().equalsIgnoreCase(regNum)){
                            System.out.println("Car data to delete ..");
                            System.out.println(temp.toString());
                        }
                    }
                }else{
                    System.out.println("Invalid Input");
                }
            }
            input = JOptionPane.showInputDialog("Do you want to continue the service?[Y-yes|N-no]").charAt(0);

        } while (input != 'N' || input != 'n');
        
    }
}
