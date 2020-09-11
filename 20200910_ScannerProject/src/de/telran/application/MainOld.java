/*package de.telran.application;

import java.util.Arrays;
import java.util.Scanner;

public class MainOld {

    static Scanner scanner = new Scanner(System.in);*/

 /*  public static void main(String[] args) {
        System.out.println("Give me the size");
        int arraySize = scanner.nextInt();
        int[] arr = new int[arraySize];
        fillArray(arr);
        System.out.println("enter a number which should be deleted");
        int numberToDelete = scanner.nextInt();
        boolean check = isNumberToDeleteInArray(arr, numberToDelete);
        printResult(arr, check, numberToDelete);
        scanner.close();
       // int[] arr1 = {1, 2, 3, 4, 5};
        //System.out.println(Arrays.toString(reverse(arr1)));
    }

    private static int[] reverse(int[] a) {
        int[] output = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            output[i] = a[a.length - 1 - i];
        }
        return output;
    }

    public static int[] fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("enter a number");
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static boolean isNumberToDeleteInArray(int[] arr, int number) {
        for (int num : arr) {
            if (num == number) {
                return true;
            }
        }
        return false;
    }

    public static int[] getArrayWithoutNumberToDelete(int[] arr, int number) {
        int count = 0;
        int[] newArr = new int[arr.length - 1];
        for (int i = 0; i < arr.length; i++) {
            if (number != arr[i]) {
                newArr[count] = arr[i];
                count++;
            }
        }
        return newArr;
    }

    public static void printResult(int[] arr, boolean check, int number) {
        if (check) {
            System.out.println(Arrays.toString(getArrayWithoutNumberToDelete(arr, number)));
        } else {
            System.out.println("try again please");
        }
    }
}
*/