public class Solution {

    public String reverseString(String input) {
        StringBuilder str = new StringBuilder(input);
        String output = String.valueOf(str.reverse());
        return output;
    }

    public int squaredNumber(int n) {
        if (n == 1) {
            return n;
        } else {
            return ((squaredNumber(n - 1) + (2 * n) - 1));
        }

    }


}
