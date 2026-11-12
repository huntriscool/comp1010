public class Date {
    public static final int MIN_YEAR = 1900;
    public static final String[] MONTH_NAMES = {
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    };

    private int day;
    private int month;
    private int year;

    /*
     * Creates a validated date. Months are 1 to 12.
     * Throws instead of silently correcting, so bad input is
     * caught early (the Client catches it and asks again).
     */
    public Date(int day, int month, int year) {
        if(!isValid(day, month, year)) {
            throw new IllegalArgumentException("Invalid date: " + day + "/" + month + "/" + year);
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getMonthName() {
        return MONTH_NAMES[month - 1];
    }

    // Leap years: every 4th year, except centuries, unless divisible by 400
    public static boolean isLeapYear(int year) {
        if(year % 400 == 0) {
            return true;
        }
        if(year % 100 == 0) {
            return false;
        }
        return year % 4 == 0;
    }

    public static int daysInMonth(int month, int year) {
        if(month == 2) {
            if(isLeapYear(year)) {
                return 29;
            }
            return 28;
        }
        if(month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        return 31;
    }

    public static int daysInYear(int year) {
        if(isLeapYear(year)) {
            return 366;
        }
        return 365;
    }

    // Checks the month first so daysInMonth is never asked about month 13
    public static boolean isValid(int day, int month, int year) {
        if(year < MIN_YEAR) {
            return false;
        }
        if(month < 1 || month > 12) {
            return false;
        }
        return day >= 1 && day <= daysInMonth(month, year);
    }

    /*
     * Orders by month then day and ignores the year, because a
     * birthday repeats every year. The tree relies on this.
     * Negative = this is earlier in the year, 0 = same, positive = later.
     */
    public int compareMonthDay(Date other) {
        if(month != other.month) {
            return month - other.month;
        }
        return day - other.day;
    }

    public boolean isInMonth(int monthNumber) {
        return month == monthNumber;
    }

    // How many days from today until the next time this birthday comes round (0 = today)
    public int daysUntilNextBirthday(Date today) {
        Date next = birthdayInYear(today.year);
        if(next.compareMonthDay(today) < 0) {
            next = birthdayInYear(today.year + 1);
        }
        return daysBetween(today, next);
    }

    // Whole years old on the given date
    public int ageOn(Date today) {
        int age = today.year - year;
        Date birthdayThisYear = birthdayInYear(today.year);
        if(today.compareMonthDay(birthdayThisYear) < 0) {
            age--;
        }
        return age;
    }

    /*
     * This birthday placed in a given year. Rule: a Feb 29 birthday
     * is celebrated on Feb 28 in years that are not leap years.
     */
    private Date birthdayInYear(int targetYear) {
        int targetDay = day;
        if(month == 2 && day == 29 && !isLeapYear(targetYear)) {
            targetDay = 28;
        }
        return new Date(targetDay, month, targetYear);
    }

    private int dayOfYear() {
        int total = day;
        for(int earlierMonth = 1; earlierMonth < month; earlierMonth++) {
            total += daysInMonth(earlierMonth, year);
        }
        return total;
    }

    /*
     * Only ever called with 'to' in the same year as 'from' or the
     * year after, which is all the next-birthday logic needs.
     */
    private static int daysBetween(Date from, Date to) {
        int difference = to.dayOfYear() - from.dayOfYear();
        if(to.year > from.year) {
            difference += daysInYear(from.year);
        }
        return difference;
    }

    // dd/mm/yyyy, which is also the format used in the save file
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", day, month, year);
    }

    public static Date fromString(String text) {
        String[] parts = text.trim().split("/");
        if(parts.length != 3) {
            throw new IllegalArgumentException("Expected dd/mm/yyyy but got: " + text);
        }
        int parsedDay = Integer.parseInt(parts[0]);
        int parsedMonth = Integer.parseInt(parts[1]);
        int parsedYear = Integer.parseInt(parts[2]);
        return new Date(parsedDay, parsedMonth, parsedYear);
    }

    @Override
    public boolean equals(Object other) {
        if(!(other instanceof Date)) {
            return false;
        }
        Date otherDate = (Date) other;
        return day == otherDate.day && month == otherDate.month && year == otherDate.year;
    }

    @Override
    public int hashCode() {
        return year * 10000 + month * 100 + day;
    }
}