package de.telran.application;

import de.telran.data.ArrayManipulation;
import de.telran.data.UserInteraction;

import static de.telran.data.UserInteraction.*;


public class Main {
    public static void main(String[] args) {
        int arraySize = getArraySize();
        int[] myArray = new int[arraySize];
        ArrayManipulation.fillArray1(myArray);
        int numberToDelete = getNumberToDelete();
        boolean check = ArrayManipulation.isNumberToDeleteInArray(myArray, numberToDelete);
        UserInteraction.printResult(myArray, check, numberToDelete);
        closeScanner();
    }

}
