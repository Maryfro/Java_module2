import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NormalizationCollectorTest {
    NormalizationCollector nc = new NormalizationCollector();

    @Test
    public void test_collect_case1() {
       Stream<Double> numbers = Stream.of(5.0, -3.0, 10.0);
        List<Double> exp = Arrays.asList(0.6153846153846154, 0.0, 1.0);
        assertEquals(exp, numbers.collect(nc));
    }
    @Test
    public void test_collect_case2() {
        Stream<Double> numbers = Stream.of(5.0, 0.0, 10.0);
        List<Double> exp = Arrays.asList(0.5, 0.0, 1.0);
        assertEquals(exp, numbers.collect(nc));
    }

}