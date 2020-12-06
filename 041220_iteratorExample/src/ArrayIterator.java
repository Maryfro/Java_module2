
public class ArrayIterator implements java.util.Iterator<Integer> {

    private final int[] arrayIterator;
    private int currentIndex = 0;

    public ArrayIterator(int[] arrayIterator) {
        this.arrayIterator = arrayIterator;
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
