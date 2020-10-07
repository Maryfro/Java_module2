
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExerciseTest {
    @Test
    public void testZeroMax() {
        int[] b1 = {0, 5, 0, 3};
        int[] b2 = {0, 4, 0, 3};
        int[] b3 = {0, 1, 0};
        int[] arr1 = Exercise.zeroMax(b1);
        int[] arr2 = Exercise.zeroMax(b2);
        int[] arr3 = Exercise.zeroMax(b3);
        Assert.assertNotNull(Exercise.zeroMax(arr1));
        Assert.assertNotNull(Exercise.zeroMax(arr2));
        Assert.assertNotNull(Exercise.zeroMax(arr3));
        Assert.assertArrayEquals(new int[]{5, 5, 3, 3}, b1);
        Assert.assertArrayEquals(new int[]{3, 4, 3, 3}, b2);
        Assert.assertArrayEquals(new int[]{1, 1, 0}, b3);
    }

    @Test
    public void testMiddleTwo() {
        Assert.assertEquals("ri", Exercise.middleTwo("string"));
        Assert.assertEquals("od", Exercise.middleTwo("code"));
        Assert.assertEquals("ct", Exercise.middleTwo("Practice"));
        assertEquals(2, Exercise.middleTwo("string").length());
        assertEquals(2, Exercise.middleTwo("code").length());
        assertEquals(2, Exercise.middleTwo("Practice").length());
    }

    @Test
    public void testNonStart() {
        assertEquals("ellohere", Exercise.nonStart("Hello", "There"));
        assertEquals("avaode", Exercise.nonStart("java", "code"));
        assertEquals("hotlava", Exercise.nonStart("shotl", "java"));

    }

    @Test
    public void testShiftLeft() {
        int[] a = {6, 2, 5, 3};
        int[] b = {1, 2};
        int[] c = {1};
        assertArrayEquals(new int[]{2, 5, 3, 6}, Exercise.shiftLeft(a));
        assertArrayEquals(new int[]{2, 1}, Exercise.shiftLeft(b));
        assertArrayEquals(new int[]{1}, Exercise.shiftLeft(c));
    }

    @Test
    public void testWordIsPalindrom() {
        assertTrue(Exercise.wordIsPalindrom("НАГАН"));
        assertTrue(Exercise.wordIsPalindrom("ШАЛАШ"));
        assertFalse(Exercise.wordIsPalindrom("ЦВЕТОК"));
    }

    @Test
    public void testStringIsPalindrom() {
        assertTrue(Exercise.stringIsPalindrom("А РОЗА УПАЛА НА ЛАПУ АЗОРА"));
        assertFalse(Exercise.stringIsPalindrom("ДОБРЫЙ ДЕНЬ"));
    }

    @Test
    public void testFillArraysWithZerosAndOnes() {
        assertArrayEquals(new int[]{0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                Exercise.fillArrayWithZerosAndOnes(new int[10], 0, 1));
    }

    @Test
    public void testFillArrayWithArithmeticProgression() {
        assertArrayEquals(new int[]{5, 7, 9, 11, 13},
                Exercise.fillArrayWithArithmeticProgression(5, 2, new int[5]));
    }

    @Test
    public void testSumMaxAndMin() {
        assertEquals(46, Exercise.sumMaxAndMin(new int[]{1, 15, 2, 45, 7}));
    }

    @Test
    public void testCommonEnd() {
        assertTrue(Exercise.commonEnd(new int[]{1, 2, 3}, new int[]{7, 3}));
        assertFalse(Exercise.commonEnd(new int[]{1, 2, 3}, new int[]{7, 3, 2}));
        assertTrue(Exercise.commonEnd(new int[]{1, 2, 3}, new int[]{1, 3}));
    }


}