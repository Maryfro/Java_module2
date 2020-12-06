

public class BackwardIterator implements java.util.Iterator<Integer> {

    private final int[] arrayIterator;
    private int currentIndex;

    public BackwardIterator(int[] arrayIterator, int currentIndex) {
        this.arrayIterator = arrayIterator;
        this.currentIndex = currentIndex;
    }

    @Override
    public boolean hasNext() {
        return currentIndex >= 0;
    }

    @Override
    public Integer next() {
        return arrayIterator[currentIndex--];
    }
}
