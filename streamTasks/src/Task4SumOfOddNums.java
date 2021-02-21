import java.util.stream.IntStream;

public class Task4SumOfOddNums {

    /**
     *
     * @param a
     * @param b must be greater or equal with a
     * @return sum of odd numbers in range from a to b
     */
    public int countSumOfOddNums(int a, int b) {
        int res = IntStream
                .rangeClosed(a, b)
                .filter(x -> x % 2 != 0)
                .sum();
        return res;
    }
}
