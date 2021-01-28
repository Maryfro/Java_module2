import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Exercise1Test {
    Exercise1 ex1 = new Exercise1();
    List<Integer> input = new ArrayList<>();

    @Test
    public void test_getUniqueNumbers_repeated() {
        Collections.addAll(input, 3, 6, 10, 3, 6, 15);
        HashSet<Integer> exp = new HashSet();
        Collections.addAll(exp, 3, 6, 10, 15);
        assertEquals(exp, ex1.getUniqueNumbers(input));
    }

    @Test
    public void test_getUniqueNumbers_repeatedAll() {
        Collections.addAll(input, 3, 3, 3, 3, 3);
        HashSet<Integer> exp = new HashSet();
        Collections.addAll(exp, 3);
        assertEquals(exp, ex1.getUniqueNumbers(input));
    }

    @Test
    public void test_getUniqueNumbers_noRepeated() {
        Collections.addAll(input, 3, -4, 100, 2, 1);
        HashSet<Integer> exp = new HashSet();
        Collections.addAll(exp, 3, -4, 100, 2, 1);
        assertEquals(exp, ex1.getUniqueNumbers(input));
    }

}