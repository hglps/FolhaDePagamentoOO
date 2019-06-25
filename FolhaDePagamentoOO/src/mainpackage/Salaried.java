package mainpackage;

public class Salaried extends Employee implements Payday, Payment{

    private double salary;
    private double baseSalary;

    public Salaried(String name, String address, String typePayment, String wayPayment, double baseSalary){
        super(name,address,typePayment,wayPayment);
        this.baseSalary = baseSalary;
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
        str = "Salaried employee\nName: " + getName() + "\nAddress: " + getAddress() + "\nWay of payment: " + getWayPayment()+ "\nID: " + getId()+ "\nPayday: " + getPayday() + "\nBase Salary: R$" + getBaseSalary() + "\nHours worked: "+ getHours() +"h\n";
        if(getPartUnion()) {
        	union = "--Union Member--" + "\nUnion Fee: R$" + getUnion().getUnionFee() + " , Service Fee(until now): R$" + getUnion().getServiceFee() + "\n\n";
        }
        else
        	union = "--Not union member--\n\n";
        return str + union;
    }



    @Override
    public boolean isPayday(String dayOfWeek) {
        return false; //TODO
    }

    @Override
    public void applyPayment() {

    }

}
