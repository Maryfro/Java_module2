import java.util.ArrayDeque;
import java.util.Comparator;

public class StackMax<T> {

    private final ArrayDeque<T> source;
    private final ArrayDeque<T> dequeTwo;
    private final Comparator<T> comparator;

    public StackMax(Comparator<T> comparator) {
        this.source = new ArrayDeque<T>();
        this.dequeTwo = new ArrayDeque<T>();
        this.comparator = comparator;
    }

    public void addLast(T el) {
        if (source.size() == 0 ||
                comparator.compare(el, dequeTwo.getLast()) >= 0) {
            dequeTwo.addLast(el);
        }
        source.addLast(el);
    }

    public T getLast() {
        return source.getLast();
    }

    public T removeLast() {
        if (source.getLast().equals(dequeTwo.getLast()))
            dequeTwo.removeLast();
        return source.removeLast();
    }

    public int size() {
        return source.size();
    }

    public T getMax() {
        return dequeTwo.getLast();
    }
}
