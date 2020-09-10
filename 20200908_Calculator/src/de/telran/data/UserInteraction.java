package de.telran.data;

import java.util.Scanner;

public class UserInteraction {
    private static Scanner scanner = new Scanner(System.in);

    public static double getParameter() {
        System.out.println("Enter a number, please");
        while(scanner.hasNextDouble()){
            System.out.println("This is not a number, enter a number please");
            scanner.next();
            scanner.hasNextDouble();
        }
        return scanner.nextDouble();
    }

    public static char getOperation() {
        System.out.println("Enter operation symbol, please");
        char operation = scanner.next().charAt(0);
        while (operation != '+' && operation != '-' && operation != '*' && operation != '/') {
            System.out.println("Wrong operation symbol, enter new symbol, please");
            operation = scanner.next().charAt(0);
        }
        return operation;
    }
    public static double getRightDivisor(double number){
        while (number == 0){
            System.out.println("error! please enter another number");
            number = scanner.nextDouble();
        }
        return number;
    }
    public static void closeScanner(){
        scanner.close();
    }
}
