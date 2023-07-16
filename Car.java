public abstract class Car {
    private String regNum;
    private String model;
    private double netPrice;

    public Car(){
        regNum = null;
        model = null;
        netPrice = 0;
    }
    public Car(String regNum,String model,double price){
        this.regNum = regNum;
        this.model = model;
        this.netPrice = price;
    }

    protected void setRegNum(String regNum){this.regNum = regNum;} //setter method
    protected void setModel(String model){this.regNum = model;}
    protected void setNetPrice(double netPrice){this.netPrice = netPrice;}


    protected String getRegNum(){return regNum;} //getter method
    protected String getModel(){return model;}
    protected double getNetPrice(){return netPrice;}

    protected abstract double calcPrice();

    public String toString(){
        return "Registration Number : " + regNum +"\nModel : " + model + "\nNet Price : " + netPrice;
    }
}
