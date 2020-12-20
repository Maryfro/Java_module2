
public class OurFixedArrayDeque<T> implements OurDeque<T> {

    private int firstElId;
    private int size;
    private Object[] source;
    private int capacity;

    public OurFixedArrayDeque(int initialCapacity) {
        this.source = new Object[initialCapacity];
        this.capacity = source.length;
    }

    @Override
    public void addFirst(Object el) {
        if (size == source.length)
            throw new DequeOverflowException();
        firstElId = (firstElId - 1) % capacity & capacity - 1;
        source[firstElId] = el;
        size++;
    }

    @Override
    public void addLast(Object el) {
        if (size == source.length)
            throw new DequeOverflowException();
        int index = (firstElId + size) % capacity;
        source[index] = el;
        size++;
    }

    @Override
    public T getFirst() {
        if (size == 0)
            throw new EmptyDequeException();
        return (T) source[firstElId];
    }

    @Override
    public T removeFirst() {
        if (size == 0)
            throw new EmptyDequeException();
        T res = (T) source[firstElId];
        source[firstElId] = null;
        firstElId = (firstElId + 1) % capacity;
        size--;
        return res;
    }


    @Override
    public T getLast() {
        if (size == 0)
            throw new EmptyDequeException();
        int lastIndex = (firstElId + size - 1) % capacity;
        return (T) source[lastIndex];
    }

    @Override
    public T removeLast() {
        if (size == 0)
            throw new EmptyDequeException();
        int lastElIndex = (firstElId + size - 1) % capacity;
        T res = (T) source[lastElIndex];
        source[lastElIndex] = null;
        size--;
        return res;
    }

    @Override
    public int size() {
        return size;
    }
}
