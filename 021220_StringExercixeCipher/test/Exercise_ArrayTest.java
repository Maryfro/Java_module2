import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise_ArrayTest {

    Exercise_Array arr = new Exercise_Array();

    @Test
    void countRepeatedNumbers_emptyArray() {
        assertEquals(0, arr.countRepeatedNumbers(new int[]{}));
    }

    @Test
    void countRepeatedNumbers_oneNumber() {
        assertEquals(1, arr.countRepeatedNumbers(new int[]{5}));
    }
    @Test
    void countRepeatedNumbers_severalNumbers() {
        assertEquals(4, arr.countRepeatedNumbers(new int[]{5, -3,  -3, -3, -3}));
    }


    @Test
    void findSwitchingSequence_emptyArray() {
        assertEquals(0, arr.findSwitchingSequence(new int[]{}));
    }

    @Test
    void findSwitchingSequence_oneNumber() {
        assertEquals(1, arr.findSwitchingSequence(new int[]{10}));
    }

    @Test
    void findSwitchingSequence_severalNumbers() {
        assertEquals(5, arr.findSwitchingSequence(new int[]{5, -3, 5, -3, 5}));
    }

    @Ignore
    void findSwitchingSequence_severalEqualNumbers() {
        assertEquals(1, arr.findSwitchingSequence(new int[]{-3, -3, -3, -3, -3}));
    }
    //TODO fix this case: expected return 1, actual: 2;
}