
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExerciseTest {
    @Test
    public void testZeroMax1() {
        int[] b1 = {0, 5, 0, 3};
        int[] arr1 = Exercise.zeroMax(b1);
        Assert.assertArrayEquals(new int[]{5, 5, 3, 3}, arr1);

    }

    @Test
    public void testZeroMax2() {
        int[] b2 = {0, 4, 0, 3};
        Assert.assertArrayEquals(new int[]{3, 4, 3, 3}, Exercise.zeroMax(b2));
    }

    @Test
    public void testZeroMax3() {
        int[] b3 = {0, 1, 0};
        Assert.assertArrayEquals(new int[]{1, 1, 0}, Exercise.zeroMax(b3));
    }

    @Test
    public void testMiddleTwo1() {
        Assert.assertEquals("ri", Exercise.middleTwo("string"));
    }

    @Test
    public void testMiddleTwo2() {
        Assert.assertEquals("od", Exercise.middleTwo("code"));

    }

    @Test
    public void testMiddleTwo3() {
        Assert.assertEquals("ct", Exercise.middleTwo("Practice"));
    }

    @Test
    public void testNonStart1() {
        assertEquals("ellohere", Exercise.nonStart("Hello", "There"));
    }

    @Test
    public void testNonStart2() {
        assertEquals("avaode", Exercise.nonStart("java", "code"));
    }


    @Test
    public void testNonStart3() {
        assertEquals("hotlava", Exercise.nonStart("shotl", "java"));
    }

    @Test
    public void testShiftLeft1() {
        int[] a = {6, 2, 5, 3};
        assertArrayEquals(new int[]{2, 5, 3, 6}, Exercise.shiftLeft(a));
    }

    @Test
    public void testShiftLeft2() {
        int[] b = {1, 2};
        assertArrayEquals(new int[]{2, 1}, Exercise.shiftLeft(b));
    }

    @Test
    public void testShiftLeft3() {
        int[] c = {1};
        assertArrayEquals(new int[]{1}, Exercise.shiftLeft(c));
    }

    @Test
    public void testWordIsPalindrom1() {
        assertTrue(Exercise.wordIsPalindrom("НАГАН"));

    }

    @Test
    public void testWordIsPalindrom2() {
        assertTrue(Exercise.wordIsPalindrom("ШАЛАШ"));
    }

    @Test
    public void testWordIsPalindrom3() {
        assertFalse(Exercise.wordIsPalindrom("ЦВЕТОК"));
    }

    @Test
    public void testStringIsPalindrom1() {
        assertTrue(Exercise.stringIsPalindrom("А РОЗА УПАЛА НА ЛАПУ АЗОРА"));
    }

    @Test
    public void testStringIsPalindrom2() {
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
    public void testCommonEnd1() {
        assertTrue(Exercise.commonEnd(new int[]{1, 2, 3}, new int[]{7, 3}));
    }

    @Test
    public void testCommonEnd2() {
        assertFalse(Exercise.commonEnd(new int[]{1, 2, 3}, new int[]{7, 3, 2}));
    }

    @Test
    public void testCommonEnd3() {
        assertTrue(Exercise.commonEnd(new int[]{1, 2, 3}, new int[]{1, 3}));
    }


}