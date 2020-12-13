import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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
    }
}


