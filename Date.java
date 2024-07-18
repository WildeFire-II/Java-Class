// Date class declaration.
public class Date {
    private int month; // 1-12
    private int day; // 1-31 based on month
    private int year; // any year

    // constructor: confirm proper value for month and day given the year
    public Date(int month, int day, int year) {
        if (month <= 0 || month > 12) {
            throw new IllegalArgumentException("month (" + month + ") must be 1-12");
        }

        if (day <= 0 || (day > daysInMonth(month, year))) {
            throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");
        }

        this.month = month;
        this.day = day;
        this.year = year;
    }

    // utility method to confirm proper day value based on month and year
    private int daysInMonth(int month, int year) {
        int[] daysPerMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        // check for leap year if month is 2 and day is 29
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }

        return daysPerMonth[month];
    }

    // utility method to check for leap year
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // return day
    public int getDay() {
        return day;
    }

    // return month
    public int getMonth() {
        return month;
    }

    // return year
    public int getYear() {
        return year;
    }

    // return a String of the form month/day/year
    @Override
    public String toString() {
        return String.format("%d/%d/%d", month, day, year);
    }
}
