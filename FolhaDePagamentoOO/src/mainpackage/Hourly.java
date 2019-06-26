package mainpackage;

public class Hourly extends Employee implements Payment{
    private int extraHours;
    private double hourlyRate;

    public Hourly(String name, String address, String typePayment, String wayPayment,  double hourlyRate){
        super(name,address,typePayment,wayPayment);
        this.hourlyRate = hourlyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    @Override
    public String toString() {
        String[] week = new String[]{"Mondays", "Tuesdays", "Wednesdays", "Thursdays", "Fridays", "Saturdays", "Sundays"};
        String str,union, payday;
        payday = "Payday : Weekly paid at ";
        payday += week[ Integer.parseInt( getPayday().substring(5,6) )] + "\n";
        str = "Hourly employee\nName: " + getName() + "\nAddress: " + getAddress() + "\nWay of payment: " + getWayPayment()+ "\nID: " + getId()+ "\nPayday: " + getPayday() + "\nHourly Rate: R$" + getHourlyRate() +"Hours worked : "+ getHours() +"h\nExtra hours worked: "+ extraHours + "h\n";
        str += payday;
        if(getPartUnion()) {
        	union = "--Union Member--" + "\nUnion Fee: R$" + getUnion().getUnionFee() + " , Service Fee(until now): R$" + getUnion().getServiceFee() + "\n\n";
        }
        else
        	union = "--Not union member--\n\n";
        return str + union;

    }

    public void calculateHours(){
        int hours = getHoursWorked();
        this.extraHours = hours - 8;
        super.calculateHours();
    }

    public int getExtraHours() {
        return extraHours;
    }

    public void calculateSalary(int dayOfWeek, int day, int lastBuss){
        if(isPayday(dayOfWeek)){
            if(getDaysWorked() >= 5){
                setWeeksWorked(0);
              double money=0;
                money = getHours()* getHourlyRate() + 1.5*getExtraHours()*getHourlyRate();
                if(getPartUnion()){
                    money -= getUnion().getServiceFee();
                    if(!getUnion().getPaidUnionFee()){
                        money -= getUnion().getUnionFee();
                        getUnion().setPaidUnionFee(true);
                    }
                }

                setSalary(money);
                System.out.println("Hourly employee "+ getName()+ " - Salary: R$" + money);
                setSalary(0);
                setDaysWorked(0);
                getUnion().setServiceFee(0);



            }

        }
    }


    private boolean isPayday(int dayOfWeek){
        return getPayday().substring(5,6).equalsIgnoreCase(Integer.toString(dayOfWeek));
    }




}
