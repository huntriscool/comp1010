public class Date {
    public int day, month, year;

    public Date(int d, int m, int y) {
        this.day = d;
        this.month = m;
        this.year = y;
    }

    public String toString() {
        return String.format("%02d/%02d/%d", day, month, year);
    }
}
