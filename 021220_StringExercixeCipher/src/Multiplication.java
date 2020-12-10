import java.util.*;

public class Multiplication {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        Collections.addAll(arrayList, 1, 5, 8, 20);
        Collections.addAll(arrayList2, 1, 5, 5, 8, 20);

        Multiplication m = new Multiplication();
        System.out.println(m.findMultipliers(arrayList, 15));   //false;
        System.out.println(m.findMultipliers(arrayList, 40));  // true;
        System.out.println(m.findMultipliers(arrayList2, 25));    // true;
        System.out.println(m.findMultipliers(arrayList, 25));   // false;
        System.out.println("---------------");
        System.out.println(m.findMultipliers_deque(arrayList, 15));
        System.out.println(m.findMultipliers_deque(arrayList, 40));
        System.out.println(m.findMultipliers_deque(arrayList2, 25));
        System.out.println(m.findMultipliers_deque(arrayList, 25));
    }

    /***
     *
     * @param initialList list with sorted values
     * @param n which is product of two multipliers.
     * @return true if you can multiply two numbers of list and receive n.
     */
    boolean findMultipliers(List<Integer> initialList, int n) {
        ArrayList<Integer> list = new ArrayList<>(initialList);
        for (int i = 0; i < list.size(); i++) {
            int a = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                int b = list.get(j);
                if (a * b == n) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean findMultipliers_deque(List<Integer> initialList, int n) {
        Deque<Integer> deque = new ArrayDeque<>(initialList);
        while (deque.size() >= 2) {
            int multiplication = deque.getFirst() * deque.getLast();
            if (multiplication > n) {
                deque.removeLast();
            } else if (multiplication < n) {
                deque.removeFirst();
            } else {
                return true;
            }
        }
        return false;
    }
}
