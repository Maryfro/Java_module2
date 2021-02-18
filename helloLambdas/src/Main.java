import java.util.*;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Function<List<String>, List<String>> lambda = (List<String> list) -> new ArrayList<>(new HashSet<>(list));

        System.out.println(lambda.apply(new ArrayList<>(Arrays.asList("hello", "world", "cat", "hello", "cat"))));

        final int a = 2, b = 3, c = 4;
        Function<Integer, Integer> f = (x) -> a * x * x + b *git x + c;

        System.out.println(f.apply(1));
    }

}
