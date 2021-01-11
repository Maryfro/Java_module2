import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaxCutPointsTest {
    MaxCutPoints mcp = new MaxCutPoints();

    @Test
    public void test_maxCutPoints_threePointsCovered(){
        List<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 10, 15, 25, 31, 40, 55, 58, 64);
        assertEquals(3, mcp.maxCoveredPoints(numbers, 9));
    }

    @Test
    public void test_maxCutPoints_threePointsCovered_inTheMiddle(){
        List<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 10, 15, 25, 27, 31, 55, 68, 74);
        assertEquals(3, mcp.maxCoveredPoints(numbers, 9));
    }

    @Test
    public void test_maxCutPoints_onePointCovered(){
        List<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 10, 20, 30, 40, 55, 65);
        assertEquals(1, mcp.maxCoveredPoints(numbers, 9));
    }

    @Test
    public void test_maxCutPoints_twoPointCovered(){
        List<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 10, 19, 30, 40, 55, 65);
        assertEquals(2, mcp.maxCoveredPoints(numbers, 9));
    }

}