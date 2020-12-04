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
        assertEquals(1, arr.countRepeatedNumbers(new int[]{5, 1,  5, 1, 1}));
    }

    @Test
    void countRepeatedNumbers_severalDiffNumbers() {
        assertEquals(6, arr.countRepeatedNumbers(new int[]{5, 6,  6, 2, -3}));
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
    void findSwitchingSequence_noRepeatingNumbers() {
        assertEquals(2, arr.findSwitchingSequence(new int[]{1, 2, 3, 4, 5, 6}));
    }


    @Test
    void findSwitchingSequence_severalNumbers_borders() {
        assertEquals(5, arr.findSwitchingSequence(new int[]{5, -3, 5, -3, 5}));
    }

    @Test
    void findSwitchingSequence_severalNumbers_notBorders() {
        assertEquals(3, arr.findSwitchingSequence(new int[]{1, -3, 5, -3, 6}));
    }

    @Test
    void findSwitchingSequence_severalEqualNumbers() {
        assertEquals(1, arr.findSwitchingSequence(new int[]{-3, -3, -3, -3, -3}));
    }

}