package de.telran.application;

import de.telran.data.Calculator;
import de.telran.data.UserInteraction;

import static de.telran.data.UserInteraction.getParameter;

public class CalculatorApplication {
    public static void main(String[] args) {
        double a = getParameter();
        double b = getParameter();
        char operation = UserInteraction.getOperation();
        Calculator.calculation(a, b, operation);
        UserInteraction.closeScanner();
    }
}
