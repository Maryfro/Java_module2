package CutMapPoints;

import java.util.*;

public class CutMap {
    static class Cut {
        int left;
        int right;

        public Cut(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public Map<Integer, Integer> countCuts(List<Cut> cuts, List<Integer> numbers) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (Integer num : numbers) {
            for (Cut cut : cuts) {
                if (cut.left <= num && cut.right >= num) {
                    count++;
                }
            }
            map.put(num, count);
            count = 0;
        }
        return map;
    }

    public Map<Integer, Integer> countCuts2(List<Cut> cuts, List<Integer> numbers) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Point> points = new ArrayList<>();
        for (Cut c : cuts) {
            points.add(new Point(c.left, Pointkind.BEGIN));
            points.add(new Point(c.right, Pointkind.END));
        }
        for (Integer num : numbers) {
            points.add(new Point(num, Pointkind.POINT));
        }
        int counter = 0;
        points.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.getValue() == o2.getValue())
                    return o1.getKind().compareTo(o2.getKind());
                return o1.getValue() - o2.getValue();
            }
        });

        for (Point p : points) {
            if (p.getKind() == Pointkind.BEGIN)
                counter++;
            else if (p.getKind() == Pointkind.END)
                counter--;
            else
                map.put(p.getValue(), counter);
        }
        return map;
    }

}
// There is a list of objects of type Cut
//class Cut{
// int left, left is lower than right
// int right,
// }
//and there is a list of Integers
//return Map with keys - numbers from list of Integers
//values - quantity of cuts, which cover this number
//pubic  Map<Integer, Integer> method(List<Cut> cuts, List<Integer> numbers)
