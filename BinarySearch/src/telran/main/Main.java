package telran.main;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 11, 13, 14, 16, 17};
        int index = binarySearch(array, 17);
         System.out.println(index >= 0 ? "index is " + index : "There is no such number in array");
        displayOddNumbers(12);
        displayEvenNumbers(12);
    }

    private static void displayEvenNumbers(int number) {
        for (int i = 0; i <= number; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
    }

    private static void displayOddNumbers(int number) {
        int count = 0;
        while (count <= number) {
            if (count % 2 != 0) {
                if (count == number || count == number - 1) {
                    System.out.println(count);
                } else {
                    System.out.print(count + ", ");
                }
            }
            count++;
        }
    }

    private static int binarySearch(int[] ints, int number) {
        int left, right, middle;
        for (left = 0, right = ints.length - 1; left <= right; ) {
            middle = (left + right) / 2;
            if (ints[middle] == number) {
                return middle;
            } else if (ints[middle] > number) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
}
