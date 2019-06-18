package mainpackage;
//TODO missing result sale method or in another class

public class Commissioned extends Salaried implements Payday{
    private double commission;

    public Commissioned(String name, String address, String typePayment, String wayPayment, double baseSalary){
        super(name,address,typePayment,wayPayment,baseSalary);
    }

    public double getCommission() {
        return commission;
    }

    @Override
    public void definePayday(){
        /*  */
    }

    @Override
    public String toString() {
        String str;
        str = "Commissioned employee\nName: " + getName() + "\nAddress: " + getAddress() + "\nWay of payment: " + getWayPayment()+ "\nID: " + getId()+ "\nPayday: " + getPayday() + "\nBase Salary: " + getBaseSalary() + "\n";
        return str;
    }
}
