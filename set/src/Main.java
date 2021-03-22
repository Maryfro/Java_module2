import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> list = new LinkedList<String>();
        Collections.addAll(list, "a", "b", "c", "c", "d");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        // System.out.println(uniqueElements(list));
        HashSet set = createSet(10);
        System.out.println(set);
        System.out.println(setBelowTen(set));
    }

    private static Set<String> uniqueElements(Collection<String> collection) {
        Set<String> result = new HashSet<>(collection);
        System.out.println("Unique elements " + result.size());
        return result;
    }

    private static HashSet<Integer> createSet(int size) {
        HashSet<Integer> set = new HashSet<>();
        while (set.size() < size) {
            set.add((int) (Math.random() * 30));
        }
        return set;
    }

    private static HashSet<Integer> setBelowTen(HashSet<Integer> set) {
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() >= 10) {
                iterator.remove();
            }
        }
        return set;
    }

   /* ListIterator listIterator = new ListIterator() {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public Object previous() {
            return null;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(Object o) {

        }

        @Override
        public void add(Object o) {

        }
    }*/
}
