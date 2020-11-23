
public class GreatestCommonDivisor {

    public int findGreatestCommonDivisorByEuclide(int a, int b) {
        int one = Math.min(a, b);
        int two = Math.abs(a - b);
        return Math.abs(two - one);
    }

    public int findGreatestCommonDivisorRecurcion(int a, int b) {
        if(a == 0){
            return b;
        }
        if (b == 0) {
            return a;
        }
        int one = a%b;
        return findGreatestCommonDivisorRecurcion(b, one);
    }
}
