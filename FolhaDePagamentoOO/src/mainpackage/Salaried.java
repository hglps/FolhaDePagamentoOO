package mainpackage;

public class Salaried extends Employee implements Payday{

    private int hours;
    private double salary;
    private double baseSalary;

    public Salaried(String name, String address, String typePayment, String wayPayment, int id, double baseSalary){
        super(name,address,typePayment,wayPayment,id);
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
}
