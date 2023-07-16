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

    public void setManufacturedDate(String date){this.manufactureDate = date;} //setter method
    public void setManufacturedState(String state){this.manufactureState = state;}

    public String getManufactureDate(){return manufactureDate;} //getter method
    public String getManufactureState(){return manufactureState;}

    @Override
    public double calcPrice(){
        double tax = super.getNetPrice() * 0.05;
        double total = super.getNetPrice() + tax;
        return total;
    }

    public String toString(){
        return super.toString() + "\nManufacturing Date : " + manufactureDate + "\nManufacturing State : " + manufactureState + "\n";
    }

}
