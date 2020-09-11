package de.telran.data;

import java.util.Arrays;

public class ArrayManipulation {

    public static void fillArray1(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = UserInteraction.getArrayElement();
        }
    }

    public static int[] getArrayWithoutNumberToDelete(int[] arr, int number) {
        int count = 0;
        int[] newArr = new int[arr.length - 1];
        for (int j : arr) {
            if (number != j) {
                newArr[count] = j;
                count++;
            }
        }
        return newArr;
    }

    public static boolean isNumberToDeleteInArray(int[] arr, int number) {
        for (int num : arr) {
            if (num == number) {
                return true;
            }
        }
        return false;
    }

}
