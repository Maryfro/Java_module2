import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task3FactorialTest {
        Task3Factorial factorial = new Task3Factorial();

    @Test
    public void testCountFactorial_5(){
        assertEquals(120, factorial.countFactorial(5));
    }

    @Test
    public void testCountFactorial_0(){
        assertEquals(1, factorial.countFactorial(0));
    }

    @Test
    public void testCountFactorial_10(){
        assertEquals(3628800, factorial.countFactorial(10));
    }

}