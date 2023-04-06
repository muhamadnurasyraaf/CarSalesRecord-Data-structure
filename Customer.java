public class Customer {
    private String custIc;
    private String phoneNum;
    private String gender;
    private int age;
    private String address;
    private String custName;
    private String disease;
    private boolean insurance;
    private boolean registered;

    public Customer(){
        custIc = null;
        phoneNum = null;
        gender = null;
        age = 0;
        address = null;
        custName = null;
        disease = null;
        insurance = false;
        registered = false;
    }

    public Customer(String ic,String pno,String g,int age,String add,String name,String d,boolean ins,boolean reg){

        custIc = ic;   
        phoneNum = pno;
        gender = g;
        this.age = age;
        address = add;
        custName = name;
        disease = d;
        insurance = ins;
        registered = reg;
    }

    public String getNoIc(){return custIc;}
    public String getPhoneNo(){return phoneNum;}
    public String getGender(){return gender;}
    public int getAge(){return age;}
    public String getAddress(){return address;}
    public String getName(){return custName;}
    public String getDisease(){return disease;}
    public boolean getInsurance(){return insurance;}
    public boolean getRegistered(){return registered;}

    //public abstract double calcBill();

    public String toString(){
        return "\nCustomer Details -->" +
        "\nIc Number : " + custIc + 
        "\nPhone Number : " + phoneNum + 
        "\nGender: " + gender +
        "\nAge : " +  age + 
        "\nAddress : " + address +
        "\nName : " + custName +
        "\nDisease : " + disease +
        "\nGet Insured : " + insurance +
        "\nRegistered : " + registered;
    }

}