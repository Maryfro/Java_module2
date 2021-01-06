import java.util.Iterator;

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
        if (size == capacity) {
            throw new DequeOverflowException();
        }
        if (firstElId == 0) {
            firstElId = capacity - 1;
        } else {
            firstElId--;
        }
        // firstElId = (firstElId + capacity - 1) % capacity;
        source[firstElId] = el;
        size++;
    }

    @Override
    public void addLast(Object el) {
        if (size == capacity)
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

    @Override
    public Iterator<T> iterator() {
        Iterator iterator = new Iterator() {
            @Override
            public boolean hasNext() {
                return firstElId < capacity;
            }

            @Override
            public Object next() {
                return source[firstElId++];
            }
        };
        return iterator;
    }

    /*class ForwardIterator implements Iterator<T> {
        source[]

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            if (currentNode == null) {
                throw new IndexOutOfBoundsException();
            }
            T res = currentNode.element;
            currentNode = currentNode.next;
            return res;
        }
    }*/
}
