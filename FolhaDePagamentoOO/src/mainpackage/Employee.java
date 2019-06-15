package mainpackage;

public class Employee{
    private String name;
    private String address;
    private String typePayment;
    private String wayPayment;
    private int id;
    private String payday;

    public Employee(String name, String address, String typePayment, String wayPayment, int id){
        this.name = name;
        this.address = address;
        this.typePayment = typePayment; // setar o payday a partir daqui :)
        this.wayPayment= wayPayment;
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTypePayment() {
        return typePayment;
    }

    public String getWayPayment() {
        return wayPayment;
    }

    public int getId() {
        return id;
    }

    public String getPayday() {
        return payday;
    }

    public void startPayday() {
        String finalPayday;
        if(typePayment.equals("c"))
            this.payday = "s 02 4";
        else if(typePayment.equals("h"))
            this.payday = "s 01 4";
        else if(typePayment.equals("m"))
            this.payday = "m 00";
    }

}
