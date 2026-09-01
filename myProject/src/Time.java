public class Time {
    public int second, minute, hour;

    public Time(int s, int m, int h) {
        this.second = s;
        this.minute = m;
        this.hour = h;
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}
