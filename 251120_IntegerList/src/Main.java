import java.util.*;

public class Main {
    public static void main(String[] args) {
        //List<Integer> javaList = new ArrayList<>();
        List<Integer> javaList = new LinkedList<>();
        ArrayIntegerList<String> strings = new ArrayIntegerList<>();

        /*try{
        list.get(10);
        }
        catch(IndexOutOfBoundsException e){
           e.printStackTrace();
          // System.out.println(e.getMessage());
*/
        ArrayIntegerList<Integer> myList = new ArrayIntegerList<>();
        myList.addLast(15);
        myList.addLast(-5);
        myList.addLast(10);
        myList.addLast(2);

        OurLinkedList<Integer> myLinkedList = new OurLinkedList<>();
        myLinkedList.addLast(150);
        myLinkedList.addLast(-50);
        myLinkedList.addLast(103);
        myLinkedList.addLast(22);


//non-static nested class
       /* Iterator<String> forwardIterator = strings.new ForwardIterator();
        while (forwardIterator.hasNext()) {
            System.out.println(forwardIterator.next());
        }*/
        //static nested class
        //Iterator<String> backwardIterator = new ArrayIntegerList.BackwardIterator<>(); -> needs source,
        // which is encapsulated
      /*  while (backwardIterator.hasNext()) {
            System.out.println(backwardIterator.next());
        }*/
       /* Iterator<Integer> backwardIterator = myList.backwardIterator();
        while (backwardIterator.hasNext()) {
            System.out.println(backwardIterator.next());
        }
        System.out.println("--------------");
        //iterable
        for (String str : strings) {
            System.out.println(str);
        }
        //equivalent
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            System.out.println(s);
*/

        System.out.println("--------------");
        OurLinkedList<Integer> linkedList = new OurLinkedList();
        linkedList.addLast(12);
        System.out.println(linkedList.remove(12));
        System.out.println("--------------");
        /*OurLinkedList.ForwardIterator forwardIteratorLinkedList = myLinkedList.new ForwardIterator();
        OurLinkedList.BackwardIterator backwardIteratorLinkedList = myLinkedList.new BackwardIterator();
        while (backwardIteratorLinkedList.hasNext()) {
            System.out.println(backwardIteratorLinkedList.next());
        }
        while (forwardIteratorLinkedList.hasNext()) {
            System.out.println(forwardIteratorLinkedList.next());
        }
*/

        for (Integer i:
                myLinkedList) {
            System.out.println(i);
        }
        System.out.println("----------");
   /*     Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };
        myLinkedList.sort(comparator);
        for (Integer i:
             myLinkedList) {
            System.out.println(i);
        }

        myList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (Integer i: myList) {
            System.out.println(i);
        }*/

        System.out.println(myList.max(Integer::compareTo));
        System.out.println(myList.min(Integer::compareTo));
        System.out.println(myLinkedList.max(Integer::compareTo));
        System.out.println(myLinkedList.min(Integer::compareTo));

    }
}


