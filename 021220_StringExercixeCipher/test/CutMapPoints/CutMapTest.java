package CutMapPoints;

import CutMapPoints.CutMap;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CutMapTest {
    CutMap cm = new CutMap();

    @Test
    public void test_countCuts_regularCase() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 5, 7, 10));
        List<CutMap.Cut> cuts = new ArrayList<>(Arrays.asList(new CutMap.Cut(0, 3), new CutMap.Cut(1, 2),
                new CutMap.Cut(6, 9), new CutMap.Cut(7, 10), new CutMap.Cut(7, 8)));
        HashMap<Integer, Integer> exp = new HashMap<>();
        exp.put(1, 2);
        exp.put(5, 0);
        exp.put(7, 3);
        exp.put(10, 1);
        assertEquals(exp, cm.countCuts(cuts, numbers));
    }

    @Test
    public void test_countCuts_border() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(0, 100));
        List<CutMap.Cut> cuts = new ArrayList<>(Arrays.asList(new CutMap.Cut(1, 3), new CutMap.Cut(1, 2),
                new CutMap.Cut(6, 9), new CutMap.Cut(7, 10), new CutMap.Cut(7, 8)));
        HashMap<Integer, Integer> exp = new HashMap<>();
        exp.put(0, 0);
        exp.put(100, 0);
        assertEquals(exp, cm.countCuts(cuts, numbers));
    }

    @Test
    public void test_countCuts_severalEqualCuts() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(0, 50, 100));
        List<CutMap.Cut> cuts = new ArrayList<>(Arrays.asList(new CutMap.Cut(50, 100), new CutMap.Cut(5, 100),
                new CutMap.Cut(50, 100)));
        HashMap<Integer, Integer> exp = new HashMap<>();
        exp.put(0, 0);
        exp.put(50, 3);
        exp.put(100, 3);
        assertEquals(exp, cm.countCuts(cuts, numbers));
    }

    @Test
    public void test_countCuts2_regularCase() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 5, 7, 10));
        List<CutMap.Cut> cuts = new ArrayList<>(Arrays.asList(new CutMap.Cut(0, 3), new CutMap.Cut(1, 2),
                new CutMap.Cut(6, 9), new CutMap.Cut(7, 10), new CutMap.Cut(7, 8)));
        HashMap<Integer, Integer> exp = new HashMap<>();
        exp.put(1, 2);
        exp.put(5, 0);
        exp.put(7, 3);
        exp.put(10, 1);
        assertEquals(exp, cm.countCuts2(cuts, numbers));
    }

    @Test
    public void test_countCuts2_border() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(0, 100));
        List<CutMap.Cut> cuts = new ArrayList<>(Arrays.asList(new CutMap.Cut(1, 3), new CutMap.Cut(1, 2),
                new CutMap.Cut(6, 9), new CutMap.Cut(7, 10), new CutMap.Cut(7, 8)));
        HashMap<Integer, Integer> exp = new HashMap<>();
        exp.put(0, 0);
        exp.put(100, 0);
        assertEquals(exp, cm.countCuts2(cuts, numbers));
    }

    @Test
    public void test_countCuts2_severalEqualCuts() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(0, 50, 100));
        List<CutMap.Cut> cuts = new ArrayList<>(Arrays.asList(new CutMap.Cut(50, 100), new CutMap.Cut(5, 100),
                new CutMap.Cut(50, 100)));
        HashMap<Integer, Integer> exp = new HashMap<>();
        exp.put(0, 0);
        exp.put(50, 3);
        exp.put(100, 3);
        assertEquals(exp, cm.countCuts2(cuts, numbers));
    }

}