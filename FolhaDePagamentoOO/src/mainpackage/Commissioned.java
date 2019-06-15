package mainpackage;

public class Commissioned extends Salaried implements Payday{
    private double commission;

    public Commissioned(String name, String address, String typePayment, String wayPayment, int id, double baseSalary){
        super(name,address,typePayment,wayPayment,id,baseSalary);
    }

    public double getCommission() {
        return commission;
    }

    @Override
    public void definePayday(){
        /*  */
    }
}
