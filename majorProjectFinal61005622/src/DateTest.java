import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DateTest {
    @Test
    public void testIsLeapYear() {
        assertTrue(Date.isLeapYear(2024));
        assertFalse(Date.isLeapYear(2025));
        assertTrue(Date.isLeapYear(2000));  //divisible by 400
        assertFalse(Date.isLeapYear(1900)); //century not divisible by 400
    }

    @Test
    public void testIsValidNormalDates() {
        assertTrue(Date.isValid(9, 1, 2008));
        assertTrue(Date.isValid(31, 12, 2000));
        assertTrue(Date.isValid(31, 1, 2025));
    }

    @Test
    public void testIsValidFebruary() {
        assertTrue(Date.isValid(29, 2, 2024));
        assertFalse(Date.isValid(29, 2, 2025));
        assertTrue(Date.isValid(29, 2, 2000));
        assertFalse(Date.isValid(29, 2, 1900));
        assertFalse(Date.isValid(30, 2, 2024));
    }

    @Test
    public void testIsValidBoundaries() {
        assertFalse(Date.isValid(0, 5, 2005));
        assertFalse(Date.isValid(32, 5, 2005));
        assertFalse(Date.isValid(31, 4, 2005)); //April has 30 days
        assertFalse(Date.isValid(10, 0, 2005));
        assertFalse(Date.isValid(10, 13, 2005));
        assertFalse(Date.isValid(10, 5, 1899)); //before MIN_YEAR
        assertTrue(Date.isValid(1, 1, 1900));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorRejectsInvalidDate() {
        new Date(31, 4, 2005);
    }

    @Test
    public void testCompareMonthDay() {
        Date jan = new Date(9, 1, 2008);
        Date mar = new Date(5, 3, 1999);
        Date marLater = new Date(20, 3, 2010);
        Date marOtherYear = new Date(5, 3, 2020);

        assertTrue(jan.compareMonthDay(mar) < 0);
        assertTrue(mar.compareMonthDay(jan) > 0);
        assertTrue(mar.compareMonthDay(marLater) < 0);
        assertEquals(0, mar.compareMonthDay(marOtherYear)); //year is ignored
    }

    @Test
    public void testDaysUntilBirthdayToday() {
        Date birthday = new Date(9, 3, 2008);
        Date today = new Date(9, 3, 2025);
        assertEquals(0, birthday.daysUntilNextBirthday(today));
    }

    @Test
    public void testDaysUntilBirthdayJustPassed() {
        Date birthday = new Date(9, 3, 2008);
        Date today = new Date(10, 3, 2025);
        assertEquals(364, birthday.daysUntilNextBirthday(today));
    }

    @Test
    public void testDaysUntilBirthdayAcrossNewYear() {
        Date birthday = new Date(1, 1, 2007);
        Date today = new Date(31, 12, 2025);
        assertEquals(1, birthday.daysUntilNextBirthday(today));
    }

    @Test
    public void testDaysUntilBirthdaySpanningLeapDay() {
        Date birthday = new Date(1, 3, 2000);
        Date today = new Date(2, 3, 2023);
        assertEquals(365, birthday.daysUntilNextBirthday(today)); //Feb 29 2024 is in between
    }

    @Test
    public void testDaysUntilLeapDayBirthday() {
        Date birthday = new Date(29, 2, 2004);
        assertEquals(28, birthday.daysUntilNextBirthday(new Date(1, 2, 2024))); //leap year: real Feb 29
        assertEquals(27, birthday.daysUntilNextBirthday(new Date(1, 2, 2025))); //non-leap: counts as Feb 28
    }

    @Test
    public void testAgeOn() {
        Date birthday = new Date(9, 3, 2008);
        assertEquals(16, birthday.ageOn(new Date(8, 3, 2025)));  //day before birthday
        assertEquals(17, birthday.ageOn(new Date(9, 3, 2025)));  //on birthday
        assertEquals(0, birthday.ageOn(new Date(9, 3, 2008)));   //born today
    }

    @Test
    public void testAgeOnLeapDayBirthday() {
        Date birthday = new Date(29, 2, 2004);
        assertEquals(20, birthday.ageOn(new Date(27, 2, 2025)));
        assertEquals(21, birthday.ageOn(new Date(28, 2, 2025))); //Feb 28 counts in non-leap years
    }

    @Test
    public void testToStringAndFromString() {
        Date date = new Date(5, 3, 2008);
        assertEquals("05/03/2008", date.toString());
        assertEquals(date, Date.fromString("05/03/2008"));
        assertEquals(date, Date.fromString(" 5/3/2008 "));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFromStringWrongFormat() {
        Date.fromString("2008-03-05");
    }

    @Test
    public void testMonthHelpers() {
        Date date = new Date(21, 10, 2006);
        assertTrue(date.isInMonth(10));
        assertFalse(date.isInMonth(11));
        assertEquals("October", date.getMonthName());
    }
}