package de.telran.data;

public class DateValidator {
    public static boolean dateValidator(int year, int month, int day) {
        return checkYear(year) && checkMonth(month) && checkDay(year, month, day);
    }

    private static boolean checkYear(int year) {
        return year > 0;

    }

    private static boolean checkMonth(int month) {
        return month > 0 && month <= 12;
    }

    private static boolean findLeapYear(int year) {
        return (year % 400 == 0 || year % 100 != 0 && year % 4 == 0);
    }

    private static int getDayPerMonth(int month, int year) {
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        if (month == 2) {
            return 28 + addDayIfLeapYear(year);
        }
        return 31;
    }

    private static int addDayIfLeapYear(int year) {
        return findLeapYear(year) ? 1 : 0;
    }

    private static boolean checkDay(int year, int month, int day) {
        if (day > 0 && day <= 28) {
            return true;
        }
        return day > 28 && day <= getDayPerMonth(month, year);
    }
}


