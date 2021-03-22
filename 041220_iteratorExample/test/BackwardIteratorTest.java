import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class BackwardIteratorTest {
    int[] arr = new int[]{-8, 10, 5, 2};
    BackwardIterator backwardIterator = new BackwardIterator(arr, arr.length - 1);
    int[] emptyArr = new int[]{};
    BackwardIterator backwardIteratorEmpty = new BackwardIterator(emptyArr, emptyArr.length - 1);

    @org.junit.jupiter.api.Test
    void test_hasNext_trueCase() {
        assertTrue(backwardIterator.hasNext());
    }

    @org.junit.jupiter.api.Test
    void test_hasNext_falseCase() {
        assertFalse(backwardIteratorEmpty.hasNext());
    }

    @org.junit.jupiter.api.Test
    void test_next() {
        assertEquals(2, backwardIterator.next());
    }

    @org.junit.jupiter.api.Test
    void test_next_Exception() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            backwardIteratorEmpty.next();
        });
    }
}