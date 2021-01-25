import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MaxTreesTest {
    MaxTrees maxTrees = new MaxTrees();
    ArrayList<MaxTrees.Point> points = new ArrayList<>();

    @Test
    void test_maxTrees() {
        points.add(new MaxTrees.Point(1, 0));
        points.add(new MaxTrees.Point(-1, 0));
        points.add(new MaxTrees.Point(0, -1));
        points.add(new MaxTrees.Point(0, 1));
        assertEquals(3, maxTrees.maxTrees(points, 3.15));
    }

    @Test
    void maxTrees_points1_alphaPI_1() {

        points.add(new MaxTrees.Point(-3, 2));

        double alpha = 3.14;//2,62-150  2,35-135
        assertEquals(1, maxTrees.maxTrees(points, alpha));
    }

    @Test
    void maxTrees_points3_alphaPI_3() {

        points.add(new MaxTrees.Point(1, 0));
        points.add(new MaxTrees.Point(1, 1));
        points.add(new MaxTrees.Point(4, -4));

        double alpha = 3.14;//2,62-150  2,35-135
        assertEquals(3, maxTrees.maxTrees(points, alpha));
    }

    @Test
    void maxTrees_points11_alphaPI_8() {

        points.add(new MaxTrees.Point(1, 0));
        points.add(new MaxTrees.Point(1, 1));
        points.add(new MaxTrees.Point(4, 2));
        points.add(new MaxTrees.Point(1.5, 3));
        points.add(new MaxTrees.Point(4, -2));
        points.add(new MaxTrees.Point(-3, 2));
        points.add(new MaxTrees.Point(-4, -2));
        points.add(new MaxTrees.Point(-2, -3));
        points.add(new MaxTrees.Point(3, -1));
        points.add(new MaxTrees.Point(4, -1));
        points.add(new MaxTrees.Point(4, -4));
        double alpha = 3.14;//2,62-150  2,35-135
        assertEquals(8, maxTrees.maxTrees(points, alpha));
    }
}