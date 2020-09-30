package de.telran.data;

public class Date {
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    private boolean checkYear() {
        return year > 0;
    }

    private boolean checkMonth() {
        return month > 0 && month <= 12;
    }

    private boolean checkDayFirstHalf() {
        return (day <= 30 && month % 2 == 0) || (day <= 31 && month % 2 != 0);
    }

    private boolean checkDaySecondHalf() {
        return (day <= 31 && month % 2 == 0) || (day <= 30 && month % 2 != 0);
    }

    private boolean checkFebruary() {
        if (day <= 28 && !findLeapYear(year)) {
            return true;
        } else if (day <= 29 && findLeapYear(year)) {
            return true;
        }
        return false;
    }

    private boolean findLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkDate() {
        if (month == 2) {
            return checkYear() && checkFebruary();
        } else if (month < 8) {
            return checkYear() && checkDayFirstHalf();
        } else {
            return checkYear() && checkMonth() && checkDaySecondHalf();
        }
    }
}
