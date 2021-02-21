import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.concat;

public class Task2 {
    public static void main(String[] args) {
        IntStream even = IntStream.of(3, 99, 7, 27, 45, 33, 15);
        IntStream odd = IntStream.of(6, 100, 22, 30, 44, 90);
        IntPredicate p = (x) -> x % 3 == 0 && x % 5 == 0;
        IntStream res = concat(even, odd)
                .sorted()
                .filter(p)
                .skip(2);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
