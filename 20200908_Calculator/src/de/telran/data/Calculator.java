package de.telran.data;

public class Calculator {
    public static void calculation(double a, double b, char operation) {
        double result;
        if (operation == '+') {
            result = a + b;
        } else if (operation == '-') {
            result = a - b;
        } else if (operation == '*') {
            result = a * b;
        } else {
            if (b == 0) {
                b = UserInteraction.getRightDivisor(b);
                result = a / b;
            } else {
                result = a / b;
            }
        }
        System.out.println("Result is " + result);
    }

}
