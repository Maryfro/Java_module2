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
                map.put(num, count);
            }
            count = 0;
        }
        return map;
    }

   /* public Map<Integer, Integer> countCuts2(List<Cut> cuts, List<Integer> numbers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.size(); i++) {
            ArrayDeque<Cut> deque = new ArrayDeque<>();
            map.put(numbers.get(i), 0);
            if (numbers.get(i) >= cuts.get(i).left && numbers.get(i) <= cuts.get(i).right)
                deque.addLast(cuts.get(i));
            else
                deque.removeFirst();
            map.put(numbers.get(i), deque.size());
        }
        return map;
    }*/

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
