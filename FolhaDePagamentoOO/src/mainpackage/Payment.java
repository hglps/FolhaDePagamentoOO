package mainpackage;

public interface Payment {

    boolean isPayday(String dayOfWeek);
    void applyPayment();
}
