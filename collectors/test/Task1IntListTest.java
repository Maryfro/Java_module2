import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class Task1IntListTest {
    Task1IntList t1 = new Task1IntList(Arrays.asList(1, 0));
    Task1IntList t2 = new Task1IntList(Arrays.asList(-5, 0, 10));
    Task1IntList t3 = new Task1IntList(Arrays.asList(1, 1));
    Task1IntList t4 = new Task1IntList(Arrays.asList(10, 2));
    Task1IntList t6 = new Task1IntList(Arrays.asList(10, 2, 1));


    @Test
    public void test_findSumOfSquaredNumbers_case1() {
        assertEquals(1, t1.findSumOfSquaredNumbers());
    }

    @Test
    public void test_findSumOfSquaredNumbers_case2() {
        assertEquals(125, t2.findSumOfSquaredNumbers());
    }

    @Test
    public void test_findProductOfSquaredNumbers_case1() {
        assertEquals(0, t1.findProductOfSquaredNumbers());
    }

    @Test
    public void test_findProductOfSquaredNumbers_case2() {
        assertEquals(1, t3.findProductOfSquaredNumbers());
    }

    @Test
    public void test_findProductOfSquaredNumbers_case3() {
        assertEquals(400, t4.findProductOfSquaredNumbers());
    }

    @Test
    public void test_findProductOfSquaredNumbers_case4() {
        assertEquals(400, t6.findProductOfSquaredNumbers());
    }



}