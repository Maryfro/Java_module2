import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {


//Prime number is a number which can be divided over itself or 1. *2,3,5,7,11
// write a method which finds all prime numbers from 2 to n.
// 1 is not a prime number.
// List<Integer> getPrimes(int upperBound){}

    /**
     * @param upperBound must be 2 or greater
     * @return
     */
    List<Integer> getPrimes(int upperBound) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 2; i <= upperBound; i++) {
            if (isPrime(i))
                res.add(i);
        }
        return res;
    }

    private boolean isPrime(int num) {
        int sqrt = (int) Math.sqrt(num);
        for (int j = 2; j <= sqrt; j++) {
            if (num % j == 0)
                return false;
        }
        return true;
    }
}
