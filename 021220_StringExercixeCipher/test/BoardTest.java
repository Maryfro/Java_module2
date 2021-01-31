import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    Board board = new Board();

    @Test
    void test_solve_boardWithZeroes() {
        int[] expected = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        int[] actual = board.solve(4, new int[]{0, 0}, new int[]{0, 0, 0, 0});
        for (int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    void test_solve_boardWithTwos() {
        int[] expected = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
        int[] actual = board.solve(4, new int[]{2, 2}, new int[]{2, 2, 2, 2});
        for (int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    void test_solve_boardWithOnes() {
        int[] expected = new int[]{1, 0, 0, 1};
        int[] expectedAnother = new int[]{0, 1, 1, 0};
        int[] actual = board.solve(2, new int[]{1, 1}, new int[]{1, 1});
        for (int i = 0; i < actual.length; i++) {
            assertTrue(expected[i] == actual[i] || expectedAnother[i] == actual[i]);
        }
    }

    @Test
    void test_solve_boardMixed() {
        int[] expected = new int[]{1, 0, 1, 0, 0, 1};
        int[] actual = board.solve(3, new int[]{2, 1}, new int[]{1, 0, 2});
        for (int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    void test_solve_boardMixed_v2() {
        int[] expected = new int[]{1, 0, 0, 1, 1, 0};
        int[] actual = board.solve(3, new int[]{1, 2}, new int[]{2, 1, 0});
        for (int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }


    @Test
    void board_NumberOfColumns_1() {
        int[] columnSum = {1};
        int[] rez = {1, 0};
        assertArrayEquals(rez, board.solve2(columnSum, 1, 0));
    }

    @Test
    void board_NumberOfColumns_3() {
        int[] columnSum = {1, 0, 2};
        int[] expected = {1, 0, 1, 0, 0, 1};

        int[] res = board.solve2(columnSum, 2, 1);

        assertArrayEquals(expected, res);
    }

    @Test
    void board_NumberOfColumns_6() {
        int[] columnSum = {1, 0, 2, 2, 0, 1};
        int[] expected = {1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0};

        int[] res = board.solve2(columnSum, 4, 2);

        assertArrayEquals(expected, res);
    }

    @Test
    void board_NumberOfColumns_5() {
        int[] columnSum = {2, 1, 1, 0, 1};

        int[] res = board.solve2(columnSum, 3, 2);

        int p = 0;
        int q = 0;
        int[] resColumnSum = new int[5];

        for (int i = 0; i < columnSum.length; i++) {
            p += res[i];
            q += res[i + columnSum.length];
            resColumnSum[i] = res[i] + res[i + columnSum.length];
        }

        assertEquals(3, p);
        assertEquals(2, q);
        assertArrayEquals(columnSum, resColumnSum);

    }

}