import java.util.Arrays;

public class Exercise {
    public static void main(String[] args) {

        int[] a = {6, 2, 5, 3};
        int[] b = {1, 2};
        int[] c = {1};
        System.out.println(Arrays.toString(shiftLeft(a))); //→ [2, 5, 3, 6]
        System.out.println(Arrays.toString(shiftLeft(b))); //→ [2, 1]
        System.out.println(Arrays.toString(shiftLeft(c))); //→  [1]
        System.out.println("-------------------------------------");
        System.out.println(wordIsPalindrom("НАГАН"));  // -> true;
        System.out.println(wordIsPalindrom("ШАЛАШ"));  // -> true;
        System.out.println(wordIsPalindrom("ЦВЕТОК"));  // -> false;
        System.out.println("-------------------------------------");
        System.out.println(stringIsPalindrom("А РОЗА УПАЛА НА ЛАПУ АЗОРА"));  // -> true;
        System.out.println(stringIsPalindrom("ДОБРЫЙ ДЕНЬ"));  // -> false;
        System.out.println("-------------------------------------");
        int[] arr = new int[10];
        System.out.println(Arrays.toString(fillArrayWithZerosAndOnes(arr, 0, 1)));
        System.out.println("-------------------------------------");
        int[] numbers = new int[5];
        System.out.println(Arrays.toString(fillArrayWithArithmeticProgression(5, 2, numbers))); // -> {5,7,9,11,13};
        System.out.println("-------------------------------------");
        int[] array = {1, 15, 2, 45, 7};
        System.out.println(sumMaxAndMin(array));
        System.out.println("-------------------------------------");
        int[] a1 = {1, 2, 3};
        int[] a2 = {7, 3};
        int[] a3 = {7, 3, 2};
        int[] a4 = {1, 3};
        System.out.println(commonEnd(a1, a2));  //→ true
        System.out.println(commonEnd(a1, a3)); // → false
        System.out.println(commonEnd(a1, a4)); // → true
        System.out.println("-------------------------------------");
        int[] b1 = {0, 5, 0, 3};
        int[] b2 = {0, 4, 0, 3};
        int[] b3 = {0, 1, 0};
        System.out.println(Arrays.toString(zeroMax(b1)));// →[5, 5, 3, 3]
        System.out.println(Arrays.toString(zeroMax(b2)));// →[3, 4, 3, 3]
        System.out.println(Arrays.toString(zeroMax(b3)));// →[1, 1, 0]
        System.out.println("-------------------------------------");
        System.out.println(nonStart("Hello", "There")); //→"ellohere"
        System.out.println(nonStart("java", "code")); // →"avaode"
        System.out.println(nonStart("shotl", "java")); //→”hotlava"
        System.out.println("-------------------------------------");
        System.out.println(middleTwo("string"));// →"ri"
        System.out.println(middleTwo("code")); // →”od"
        System.out.println(middleTwo("Practice")); // → “ct"
    }

    public static String middleTwo(String str) {
        return str.substring(str.length() / 2 - 1, str.length() / 2 + 1);
    }

    public static String nonStart(String a, String b) {
        return a.substring(1) + b.substring(1);
    }

    public static int[] zeroMax(int[] nums) {
        int temp = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] % 2 != 0) {
                temp = nums[i];
            }
            if (nums[i] == 0) {
                nums[i] = temp;
            }
        }
        return nums;
    }

    public static boolean commonEnd(int[] a1, int[] a2) {
        return a1[0] == a2[0] || a1[a1.length - 1] == a2[a2.length - 1];
    }

    public static int sumMaxAndMin(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max > arr[i]) {
                max = arr[i];
            } else if (min < arr[i]) {
                min = arr[i];
            }
        }
        return max + min;
    }

    public static int[] fillArrayWithArithmeticProgression(int start, int diff, int[] arr) {
        arr[0] = start;
        for (int i = 1; i < arr.length; i++) {
            start += diff;
            arr[i] = start;
        }
        return arr;
    }

    public static int[] fillArrayWithZerosAndOnes(int[] arr, int a, int b) {
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr[i] = a;
            } else {
                arr[i] = b;
            }
        }
        return arr;
    }

    public static boolean stringIsPalindrom(String input) {
        input = input.replaceAll(" ", "");
        return wordIsPalindrom(input);
    }

    public static boolean wordIsPalindrom(String input) {
        return new StringBuffer(input).reverse().toString().equals(input);
    }

    public static int[] shiftLeft(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 1; i < result.length; i++) {
            result[i - 1] = arr[i];
        }
        result[result.length - 1] = arr[0];
        return result;
    }


}
