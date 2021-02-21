import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Task3Factorial {

    public int countFactorial(int n) {
        int[] arr = new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }
        int res = IntStream
                .rangeClosed(1, n)
                .reduce(1, (x, y) -> x * y);
        return res;
    }
}
