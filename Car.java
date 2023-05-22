public abstract class Car {
    protected String regNum;
    protected String model;
    protected double netPrice;

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

    public String getRegNum(){return regNum;}
    public String getModel(){return model;}
    public double getNetPrice(){return netPrice;}

    public abstract double calcPrice();

    public String toString(){
        return "Registration Number : " + regNum +"\nModel : " + model + "\nNet Price : " + netPrice;
    }
}
