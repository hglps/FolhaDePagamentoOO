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
        String str, union;
        str = "Commissioned employee\nName: " + getName() + "\nAddress: " + getAddress() + "\nWay of payment: " + getWayPayment()+ "\nID: " + getId()+ "\nPayday: " + getPayday() + "\nBase Salary: " + getBaseSalary() + "\n";
        if(getPartUnion()) {
        	union = "--Union Member--" + "\nUnion Fee: R$" + getUnionFee() + " , Service Fee(until now): R$" + getServiceFee() + "\n";
        	//TODO ta dando erro no UnionContract---------------------------------------------------------------------------------------------------- fazer UML
        }
        else
        	union = "--Not union member--";
        return str + union;
    }
}
