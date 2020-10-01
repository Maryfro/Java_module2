package telran.app;

import java.util.Arrays;

public class Main {
    public static <sb3> void main(String[] args) {
        StringBuffer sb = new StringBuffer(" ");
        StringBuffer sb1 = new StringBuffer(32);
        char[] c = {'s', 't', 'r', 'i', 'n', 'g'};
        StringBuffer sb2 = new StringBuffer(String.valueOf(c));
        sb2.append("       world");
        //System.out.println(sb2.capacity());
        //System.out.println(sb2.length());
        //System.out.println(sb2);
        sb2.setCharAt(6, ',');
        //System.out.println(sb2);
        sb2.insert(8, "hello");
        // System.out.println(sb2);
        sb2.delete(14, 18);
        // System.out.println(sb2);
        //System.out.println(sb2.reverse());
        int[] nums = {1, 2, 3};
        sb2.append(5).append("!!!").append(Arrays.toString(nums)).append(true);
        System.out.println(sb2);
        String s = new String(sb2);
        System.out.println(sb2.reverse());
        System.out.println(s);
        System.out.println("----------");
        System.out.println(sumNumbers("12345"));
        System.out.println("----------");
        StringBuffer sb4 = new StringBuffer("12345");
        System.out.println(sumNumbers(sb4));
    }

    private static int sumNumbers(String input) {
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            sum += Integer.parseInt(input.substring(i, i + 1));
        }
        return sum;
    }

    private static int sumNumbers(StringBuffer input) {
        char[] chars = new char[input.length()];
        input.getChars(0, input.length(), chars, 0);
        int sum = 0;
        for (char ch : chars) {
            sum += Character.digit(ch, 10);
        }
        return sum;
    }
}




