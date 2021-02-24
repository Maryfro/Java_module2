import java.util.NoSuchElementException;
import java.util.stream.IntStream;

public class Task4SumOfOddNums {

    /**
     * @param a
     * @param b throws NoSuchElementException if no odd numbers found in range or a>b
     * @return sum of odd numbers in range from a to b
     */
    public int countSumOfOddNums(int a, int b) {
        return IntStream
                .rangeClosed(a, b)
                .filter(x -> x % 2 != 0)
                .reduce(Integer::sum).orElseThrow(NoSuchElementException::new);
    }
}
