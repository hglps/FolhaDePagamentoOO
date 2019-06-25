package mainpackage;

public class Hourly extends Employee implements Payday, Payment{
    private int extraHours;
    private double hourlyRate;
    private double salary;

    public Hourly(String name, String address, String typePayment, String wayPayment,  double hourlyRate){
        super(name,address,typePayment,wayPayment);
        this.hourlyRate = hourlyRate;
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
        String str,union;
        str = "Hourly employee\nName: " + getName() + "\nAddress: " + getAddress() + "\nWay of payment: " + getWayPayment()+ "\nID: " + getId()+ "\nPayday: " + getPayday() + "\nHourly Rate: R$" + getHourlyRate() +"Hours worked : "+ getHours() +"h\nExtra hours worked: "+ extraHours + "h\n";
        if(getPartUnion()) {
        	union = "--Union Member--" + "\nUnion Fee: R$" + getUnion().getUnionFee() + " , Service Fee(until now): R$" + getUnion().getServiceFee() + "\n\n";
        }
        else
        	union = "--Not union member--\n\n";
        return str + union;

    }


    @Override
    public boolean isPayday(String dayOfWeek) {
        return false;
    }

    @Override
    public void applyPayment() {

    }

    public void calculateHours(){
        int hours = getHoursWorked();
        this.extraHours = hours - 8;
        super.calculateHours();
    }


}
