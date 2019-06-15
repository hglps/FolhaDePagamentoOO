package mainpackage;

public class Hourly extends Employee implements Payday {
    private int hours;
    private double hourlyRate;
    private double salary;

    public Hourly(String name, String address, String typePayment, String wayPayment, int id, double hourlyRate){
        super(name,address,typePayment,wayPayment,id);
        this.hourlyRate = hourlyRate;
    }
    public int getHours() {
        return hours;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public void definePayday() {
        /*  */
    }
}
