import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{-8, 10, 5, 2};
        //  Iterator<Integer> iterator = new ArrayIterator(arr);

      /*  while(iterator.hasNext()){
            int currentElement = iterator.next();
            System.out.println(currentElement);
        }*/

        BackwardIterator backwardIterator = new BackwardIterator(arr, arr.length - 1);
        while (backwardIterator.hasNext()) {
            System.out.println(backwardIterator.next());
        }
        IteratorWithIncreasingValues iteratorIncreasing = new IteratorWithIncreasingValues(arr);
        while (iteratorIncreasing.hasNext()) {
            System.out.println(iteratorIncreasing.next());
        }
        System.out.println(Arrays.toString(arr));


    }


    // write class iterator which can iterate backwards

    //write iterator which iterate over int[], which values are increasing. input array should remain the same.
    //use sorting.
}
