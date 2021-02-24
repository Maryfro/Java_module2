import java.util.stream.LongStream;

public class Task3Factorial {

    public long countFactorial(int n) {
        return LongStream
                .rangeClosed(1, n)
                .reduce(1, (x, y) -> x * y);
    }
}
