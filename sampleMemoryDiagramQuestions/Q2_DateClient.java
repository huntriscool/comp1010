class Date {
    public int day, month, year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
}

public class Q2_DateClient {
    public static void main(String[] args) {
        Date d1 = new Date(15, 8, 2023);
        Date d2 = new Date(d1.month, d1.day, d1.year); 
        d2.month++;
        Date d3 = d1;
    }
}
