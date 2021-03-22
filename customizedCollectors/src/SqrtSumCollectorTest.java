import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SqrtSumCollectorTest {
    SqrtSumCollector ssc = new SqrtSumCollector();

    @Test
    public void test_collect_case1() {
        Stream<Double> numbers = Stream.of(5.0, -3.0, 10.0);
        assertEquals(6.68, numbers.collect(ssc), 0.01);
    }

    @Test
    public void test_collect_case2() {
        Stream<Double> numbers = Stream.of(1.0, 0.0);
        assertEquals(0.70, numbers.collect(ssc), 0.01);
    }
}