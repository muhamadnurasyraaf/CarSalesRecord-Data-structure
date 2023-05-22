public class Imported extends Car{
    String importId;
    String country;
    double importTax;
    
    public Imported(){
        super();
        importId = null;
        country = null;
        importTax = 0;
    }

    public Imported(String regNum,String model,double price,String id,String ctry,String tax){
        super(regNum, model, price);
        importId = id;
        country = ctry;
        importTax = tax;
    }

    public String getImportId(){return importId;}
    public String getCountry(){return country;}
    public String getImportTax(){return importTax;}

    public double calcPrice(){
        double netprice = super.getNetPrice();
        double grossPrice = netprice + (netprice * 0.2);

        return grossPrice;
    }

    public String toString(){
        return super.toString() + "\nImport ID: " + importId + "\nCountry Import: " + country + "\nImport Tax: " + importTax + "\nGross Price: " + calcPrice();
    }

}
