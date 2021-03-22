import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrimeNumberTest {
    PrimeNumber pn = new PrimeNumber();
    List<Integer> exp = new ArrayList<>();

    @Test
    void test_getPrimes_upperBound15() {
        Collections.addAll(exp, 2, 3, 5, 7, 11, 13);
        assertEquals(exp, pn.getPrimes(15));
    }

    @Test
    void test_getPrimes_upperBound2() {
        Collections.addAll(exp, 2);
        assertEquals(exp, pn.getPrimes(2));
    }

    @Test
    void test_getPrimes_upperBound30() {
        Collections.addAll(exp, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        assertEquals(exp, pn.getPrimes(30));
    }


}