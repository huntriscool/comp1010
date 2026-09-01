public class DateTime {
    public Date date;
    public Time time;

    public DateTime(Date d, Time t) {
        this.date = d;
        this.time = t;
    }
    
    public String toString() {
        return "Current date: " + this.date + ", Current time: " + this.time;
    }
}