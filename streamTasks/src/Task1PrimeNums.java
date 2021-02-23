import java.util.stream.IntStream;

public class Task1PrimeNums {

    /**
     *
     * @param n n must be greater than 0
     * @return true if a number is a prime number
     */
    public boolean isPrime(int n) {
        return IntStream.rangeClosed(2, (int)Math.sqrt(n))
                .noneMatch(i -> n % i == 0);
    }
}
