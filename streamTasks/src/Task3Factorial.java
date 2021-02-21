import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Task3Factorial {

    public int countFactorial(int n) {
        return IntStream
                .rangeClosed(1, n)
                .reduce(1, (x, y) -> x * y);
    }
}
