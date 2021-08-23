import java.util.HashSet;
import java.util.Set;

/**
 * a positive number is called boring if all of the digits
 * at even positions in the number are even
 * and all of the digits at odd positions are odd.
 * The digits are enumerated from left to right starting from 1.
 * For example, the number 1478 is boring as the odd positions include the digits {1, 7}
 * which are odd and even positions include the digits {4, 8} which are even.
 * Given two numbers L and R, Ron wants to count
 * how many numbers in the range [L, R] (L and R inclusive) are boring.
 */

public class BoringNumbers {
    public static int countBoringNumbers(int l, int r) {
        Set<Integer> list = new HashSet<>();
        int num = l;
        while (num <= r) {
            char[] numChar = String.valueOf(num).toCharArray();
            list.add(num);
            for (int i = 0; i < numChar.length; i++) {
                if (i % 2 != 0 && numChar[i] % 2 != 0) {
                    list.remove(num);
                    break;
                } else if (i % 2 == 0 && numChar[i] % 2 == 0) {
                    list.remove(num);
                    break;
                }
            }
            num++;
        }
        return list.size();
    }

    public static void main(String[] args) {

         System.out.println(countBoringNumbers(5, 15)); //6
        System.out.println(countBoringNumbers(120, 125)); //3
        System.out.println(countBoringNumbers(779, 783)); //2

    }

}
