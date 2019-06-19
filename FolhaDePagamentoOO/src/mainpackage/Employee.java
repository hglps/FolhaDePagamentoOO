package mainpackage;

public class Employee extends UnionContract{
    //TODO olhar o extends
	private String name;
    private String address;
    private String typePayment;
    private String wayPayment;
    private String id;
    private String payday;
    private UnionContract union = new UnionContract();
    private boolean partUnion;
    //TODO

    public Employee(String name, String address, String typePayment, String wayPayment){
        this.name = name;
        this.address = address;
        this.typePayment = typePayment; // setar o payday a partir daqui :)
        this.wayPayment= wayPayment;
    }

    public void enterUnion(double unionFee, String name, int patternId){
    	partUnion = true;
    	union.setUnionFee(unionFee);
        union.setUnionId(patternId, name);
    }

    public String getId() {
        return id;
    }

    public String getPayday() {
        return payday;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTypePayment() {
        return typePayment;
    }

    public String getWayPayment() {
        return wayPayment;
    }
    
    public boolean getPartUnion() {
    	return partUnion;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTypePayment(String typePayment) {
        this.typePayment = typePayment;
    }

    public void setWayPayment(String wayPayment) {
        this.wayPayment = wayPayment;
    }

    public void setPayday(String payday) {
        this.payday = payday;
    }


    public void setPartUnion(boolean partUnion) {
        this.partUnion = partUnion;
    }

    public void setId(String id) {
        this.id = id;
    }

    



    public void startPayday() {
        if(typePayment.equals("c"))
            this.payday = "s 02 4";
        else if(typePayment.equals("h"))
            this.payday = "s 01 4";
        else if(typePayment.equals("m"))
            this.payday = "m 00";
    }

}
