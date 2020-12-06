import java.util.ArrayList;
import java.util.Arrays;

public class IteratorWithIncreasingValues implements java.util.Iterator<Integer> {

    private final int[] arrayIterator;
    private int currentIndex = 0;

    public IteratorWithIncreasingValues(int[] arrayIterator) {
        int[] copy = Arrays.copyOf(arrayIterator, arrayIterator.length);
        Arrays.sort(copy);
        this.arrayIterator = copy;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < arrayIterator.length;
    }

    @Override
    public Integer next() {
        return arrayIterator[currentIndex++];
    }
}
