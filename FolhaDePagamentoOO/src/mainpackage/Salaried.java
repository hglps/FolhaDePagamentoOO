package mainpackage;

public class Salaried extends Employee implements Payday{

    private int hours;
    private double salary;
    private double baseSalary;

    public Salaried(String name, String address, String typePayment, String wayPayment, double baseSalary){
        super(name,address,typePayment,wayPayment);
        this.baseSalary = baseSalary;
    }
    public int getHours() {
        return hours;
    }

    public double getSalary() {
        return salary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    @Override
    public void definePayday() {
        /*  */
    }

    @Override
    public String toString() {
        String str;
        str = "Salaried employee\nName: " + getName() + "\nAddress: " + getAddress() + "\nWay of payment: " + getWayPayment()+ "\nID: " + getId()+ "\nPayday: " + getPayday() + "\nBase Salary: R$" + getBaseSalary() + "\n";
        return str;
    }
}
