package mainpackage;
//TODO TBC
public abstract class UnionContract {
    private double unionFee;
    private double serviceFee;
    private String unionId;
    private boolean unionMember;
    private boolean paidUnionFee;


    public void setPaidUnionFee(boolean paidUnionFee) {
        this.paidUnionFee = paidUnionFee;
    }

    public void setUnionId(int pattern, String name) {
        if(name.length() < 3)
            this.unionId = pattern + "@" + name.toLowerCase();
        else
            this.unionId = pattern + "@" + name.substring(0,3).toLowerCase();
    }

    public void setUnionFee(double unionFee) {
        this.unionFee = unionFee;
    }

    public void setServiceFee(double serviceFee) {
        this.serviceFee = serviceFee;
    }

    public void addServiceFee(double serviceFee) {
        this.serviceFee += serviceFee;
    }

    public void setUnionMember(boolean unionMember) {
        this.unionMember = unionMember;
    }

    public double getUnionFee() {
        return unionFee;
    }

    public double getServiceFee() {
        return serviceFee;
    }

    public String getUnionId() {
        return unionId;
    }

    public boolean getPaidUnionFee() {
        return paidUnionFee;
    }

    public boolean getUnionMember(){
        return unionMember;
    }
}
