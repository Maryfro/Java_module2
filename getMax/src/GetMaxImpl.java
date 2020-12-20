import java.util.Iterator;

public class GetMaxImpl implements GetMax {
    private final static int INITIAL_CAPACITY = 16;
    private int size;
    private Integer[] source;

    public GetMaxImpl() {
        this.source = new Integer[INITIAL_CAPACITY];
    }

    @Override
    public void addLast(Integer el) {
        if (size == source.length) {
            Integer[] newSource = new Integer[size + INITIAL_CAPACITY];
            System.arraycopy(source, 0, newSource, 0, source.length);
            source = newSource;
        }
        source[size++] = el;
    }

    @Override
    public Integer getLast() {
        return source[size - 1];
    }

    @Override
    public Integer removeLast() {
        Integer lastEl = source[size - 1];
        source[size - 1] = null;
        size--;
        return lastEl;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Integer getMax() {
        if (size == 0){
            throw new IndexOutOfBoundsException();
        }
            Integer max = getLast();
        for (int i = 1; i <= size; i++) {
            if (max < source[size - i]) {
                max = source[size - i];
            }
        }
        return max;

    }


}
