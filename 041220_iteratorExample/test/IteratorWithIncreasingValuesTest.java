import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IteratorWithIncreasingValuesTest {

    int[] arr = new int[]{-8, 10, 5, 2};
    IteratorWithIncreasingValues iteratorIncreasing = new IteratorWithIncreasingValues(arr);
    int[] arr1 = new int[]{};
    IteratorWithIncreasingValues iteratorEmpty = new IteratorWithIncreasingValues(arr1);


    @org.junit.jupiter.api.Test
    void test_hasNext_trueCase() {
        assertTrue(iteratorIncreasing.hasNext());
    }

    @org.junit.jupiter.api.Test
    void test_hasNext_falseCase() {
        assertFalse(iteratorEmpty.hasNext());
    }

    @org.junit.jupiter.api.Test
    void test_next() {
        assertEquals(-8, iteratorIncreasing.next());
    }

    @org.junit.jupiter.api.Test
    void test_next_Exception() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            iteratorEmpty.next();
        });
    }

    @org.junit.jupiter.api.Test
    void test_initialArray() {
        int[] initArr = new int[]{-8, 10, 5, 2};
        while (iteratorIncreasing.hasNext()) {
            iteratorIncreasing.next();
        }
        for (int i = 0; i < initArr.length; i++) {
            assertEquals(initArr[i], arr[i]);
        }
    }


}