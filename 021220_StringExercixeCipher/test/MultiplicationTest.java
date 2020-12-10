import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MultiplicationTest {
    Multiplication m = new Multiplication();

    @Test
    public void test_findMultipliers_twoElements_trueCase() {
        List<Integer> list = Arrays.asList(2, 5);

        assertTrue(m.findMultipliers(list, 10));
    }

    @Test
    public void test_findMultipliers_twoElements_falseCase() {
        List<Integer> list = Arrays.asList(5, 10);

        assertFalse(m.findMultipliers(list, 3));
    }

    @Test
    public void testSolution_twoElements_falseCase() {
        List<Integer> list = Arrays.asList(5, 15);

        assertFalse(m.findMultipliers(list, 10));
    }

    @Test
    public void testSolution4() {
        List<Integer> list = Arrays.asList(5, 15);

        assertFalse(m.findMultipliers(list, 15));
        assertFalse(m.findMultipliers(list, 5));
    }

    @Test
    public void testSolution_universalCase() {
        List<Integer> list = Arrays.asList(2, 5, 10, 11, 11, 20, 23);

        assertTrue(m.findMultipliers(list, 55));
        assertTrue(m.findMultipliers(list, 22));
        assertTrue(m.findMultipliers(list, 40));
        assertTrue(m.findMultipliers(list, 46));

        assertTrue(m.findMultipliers(list, 253));
        assertTrue(m.findMultipliers(list, 460));
        assertTrue(m.findMultipliers(list, 121));

        assertFalse(m.findMultipliers(list, 400));
        assertFalse(m.findMultipliers(list, 80));
    }
}
