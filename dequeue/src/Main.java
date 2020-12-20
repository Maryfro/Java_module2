import java.util.ArrayDeque;

public class Main {

    // Design implementation of data structure, which effectively does the following:
    // +addLast(Integer el)
    //removeLast(): Integer
    //getLast(): Integer
    //size()
    //getMax(): Integer

    // in implementation we can use java collections

    public static void main(String[] args) {
    OurFixedArrayDeque<Integer> deque = new OurFixedArrayDeque<>(4);
     deque.addFirst(1);
     deque.addFirst(12);
        System.out.println("get first " + deque.getFirst());
        System.out.println("get last " + deque.getLast());


    }

}
