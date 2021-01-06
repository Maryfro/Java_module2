import java.util.ArrayDeque;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        OurFixedArrayDeque<Integer> deque = new OurFixedArrayDeque<>(4);
        deque.addFirst(1);
        deque.addFirst(12);
        //deque.addLast(101);
        //deque.addLast(101);
        System.out.println("get first " + deque.getFirst());
        System.out.println("get last " + deque.getLast());
        ArrayDeque<Integer> deque1 = new ArrayDeque<>();

        /*for (Integer i : deque) {
            System.out.println(i);
        }*/

        Iterator<Integer> iterator = deque.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            System.out.println(i);
        }
//  Iterator<String> iterator = strings.iterator();
//        while (iterator.hasNext()) {
//            String s = iterator.next();
//            System.out.println(s);

    }

}
