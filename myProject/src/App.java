import java.time.LocalDate;
import java.time.LocalTime;

public class App {
    public static void main(String[] args) throws Exception {
        //sets min sec hour to current local time
        LocalTime nowTime = LocalTime.now();
        int min = nowTime.getMinute();
        int sec = nowTime.getSecond();
        int hour = nowTime.getHour();

        //sets day mon year to current local date
        LocalDate nowDate = LocalDate.now();
        int day = nowDate.getDayOfMonth();
        int month = nowDate.getMonthValue();
        int year = nowDate.getYear();

        //sets current time and date
        Time currentTime = new Time(sec, min, hour);
        Date currentDate = new Date(day, month, year);
        DateTime currentDateTime = new DateTime(currentDate, currentTime);

        //prints current date time
        System.out.println(currentDateTime);
    }
}
