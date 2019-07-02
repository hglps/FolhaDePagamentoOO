package payment;

public abstract class TimeCard {
    private int hourIn;
    private int hourOut;
    private int minuteIn;
    private int minuteOut;
    private int hoursWorked;

    public abstract void calculateHours();//TODO //
    public abstract void addDayWorked();//TODO  //

    public int getHoursWorked(){
        return hoursWorked;
    }

    private void setHoursWorked(int hourIn, int hourOut, int minuteIn, int minuteOut){

        if(hourOut < hourIn)
            this.hoursWorked = (24 - hourIn) + hourOut;
        else
            this.hoursWorked = hourOut - hourIn;

        if(minuteOut < minuteIn)
            this.hoursWorked -=1;
    }

    public void setHourIn(int hourIn) {
        this.hourIn = hourIn;
    }

    public int getHourIn() {
        return hourIn;
    }

    public int getHourOut() {
        return hourOut;
    }

    public int getMinuteIn() {
        return minuteIn;
    }

    public int getMinuteOut() {
        return minuteOut;
    }

    public void setHourOut(int hourOut) {
        this.hourOut = hourOut;
    }

    public void setMinuteIn(int minuteIn) {
        this.minuteIn = minuteIn;
    }

    public int setMinuteOut(int minuteOut) {
        this.minuteOut = minuteOut;
        setHoursWorked(hourIn, hourOut, minuteIn, minuteOut);
        return hoursWorked;
    }

}
