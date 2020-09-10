package de.telran.data;

import java.util.Scanner;

public class UserInteraction {
    public static Scanner scanner = new Scanner(System.in);

    public static int getArraySize() {
        System.out.println("Give me the size of your array ");
        return scanner.nextInt();
    }

    public static int getArrayElement() {
        System.out.println("Enter a number, please");
        return scanner.nextInt();
    }
    public static int getNumberToDelete() {
        System.out.println("enter a number which should be deleted");
        return scanner.nextInt();
    }

    public static void closeScanner(){
        scanner.close();
    }

}
