public class Solution {

    public String reverseString(String input) {
        StringBuffer str = new StringBuffer(input);
        String output = String.valueOf(str.reverse());
        return output;
    }

    public int squaredNumber(int n) {
        if (n == 0) {
            return 1;
        } else if (n==1){
            return n;
        }else {
            return ((squaredNumber(n-1)+ (2*n)-1));
        }

    }


}
