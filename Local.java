public class Local extends Car{

    private String manufactureDate;
    private String manufactureState;

    public Local(){
        super();
        manufactureDate = null;
        manufactureState = null;
    }
    public Local(String regnum,String model,double netPrice,String date,String state){
        super(regnum, model, netPrice);
        manufactureDate = date;
        manufactureState = state;
    }

    public String getManufactureDate(){return manufactureDate;}
    public String getManufactureState(){return manufactureState;}

    public double calcPrice(){
        double tax = netPrice * 0.05;
        double total = netPrice + tax;
        return total;
    }

    public String toString(){
        return super.toString() + "\nManufacturing Date : " + manufactureDate + "\nManufacturing State : " + manufactureState;
    }

}
