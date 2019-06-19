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
        String str,union;
        str = "Salaried employee\nName: " + getName() + "\nAddress: " + getAddress() + "\nWay of payment: " + getWayPayment()+ "\nID: " + getId()+ "\nPayday: " + getPayday() + "\nBase Salary: R$" + getBaseSalary() + "\n";
        if(getPartUnion()) {
        	union = "--Union Member--" + "\nUnion Fee: R$" + getUnionFee() + " , Service Fee(until now): R$" + getServiceFee() + "\n";
        }
        else
        	union = "--Not union member--";
        return str + union;
    }
}
