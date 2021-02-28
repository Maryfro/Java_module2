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
        assertEquals(6.708203932499369, numbers.collect(ssc));
    }
    @Test
    public void test_collect_case2() {
        Stream<Double> numbers = Stream.of( 1.0, 0.0);
        assertEquals(1.0, numbers.collect(ssc));
    }
}