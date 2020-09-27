package de.telran.app;

import de.telran.data.Date;

public class App {
    public static void main(String[] args) {
        System.out.println(new Date(2019, 2, 29).checkDate());
        System.out.println(new Date(2020, 2, 29).checkDate());
        System.out.println(new Date(2020, 8, 31).checkDate());
        System.out.println(new Date(2020, 9, 31).checkDate());
    }
}
