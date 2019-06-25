package mainpackage;
//TODO missing result sale method or in another class

public class Commissioned extends Salaried implements Payday, Payment{
    private double commission;
    private double commissionRate;

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public Commissioned(String name, String address, String typePayment, String wayPayment, double baseSalary, double commissionRate){
        super(name,address,typePayment,wayPayment,baseSalary);
        this.commissionRate = commissionRate;
    }

    public double getCommission() {
        return commission;
    }

    @Override
    public void definePayday(){
        /*  */
    }



    @Override
    public boolean isPayday(String dayOfWeek) {
        return super.isPayday(dayOfWeek);
    }

    @Override
    public void applyPayment() {
        super.applyPayment();
    }

    @Override
    public String toString() {
        String str, union;
        str = "Commissioned employee\nName: " + getName() + "\nAddress: " + getAddress() + "\nWay of payment: " + getWayPayment()+ "\nID: " + getId()+ "\nPayday: " + getPayday() + "\nBase Salary: " + getBaseSalary() + "\nHours worked: "+ getHours() +"h\nCommission : R$" + getCommission() +"\n";
        if(getPartUnion()) {
        	union = "--Union Member--" + "\nUnion Fee: R$" + getUnion().getUnionFee() + " , Service Fee(until now): R$" + getUnion().getServiceFee() + "\n\n";
        }
        else
        	union = "--Not union member--\n\n";
        return str + union;
    }


}
