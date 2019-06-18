package mainpackage;

public class Hourly extends Employee implements Payday {
    private int hours;
    private double hourlyRate;
    private double salary;

    public Hourly(String name, String address, String typePayment, String wayPayment,  double hourlyRate){
        super(name,address,typePayment,wayPayment);
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

    @Override
    public String toString() {
        String str;
        str = "Hourly employee\nName: " + getName() + "\nAddress: " + getAddress() + "\nWay of payment: " + getWayPayment()+ "\nID: " + getId()+ "\nPayday: " + getPayday() + "\nHourly Rate: R$" + getHourlyRate() + "\n";
        return str;

    }
}
