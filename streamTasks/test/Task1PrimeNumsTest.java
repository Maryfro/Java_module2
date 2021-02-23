import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task1PrimeNumsTest {
    Task1PrimeNums pn = new Task1PrimeNums();

    @Test
    public void testIsPrime_TrueCase_2() {
        assertTrue(pn.isPrime(2));
    }

    @Test
    public void testIsPrime_TrueCase_97() {
        assertTrue(pn.isPrime(97));
    }
    @Test
    public void testIsPrime_FalseCase_42() {
        assertFalse(pn.isPrime(42));
    }

    @Test
    public void testIsPrime_FalseCase_6() {
        assertFalse(pn.isPrime(6));
    }

    @Test
    public void testIsPrime_FalseCase_1000() {
        assertFalse(pn.isPrime(1000));
    } @Test
    public void testIsPrime_FalseCase_888() {
        assertFalse(pn.isPrime(888));
    }



}