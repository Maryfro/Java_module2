import java.util.Iterator;

public class ArrayIntegerList<T> implements OurList<T> {
    private final static int INITIAL_CAPACITY = 16;
    private int size;
    private Object[] source;

    public ArrayIntegerList() {
        source = new Object[INITIAL_CAPACITY];
    }

    @Override
    public void addLast(T element) {
       /* if (element == null) {
            throw new NullPointerException();
        }*/
        if (size == source.length) {
            increaseCapacity();
        }
        source[size++] = element;
    }

    //O(n), where n is size
    void increaseCapacity() {
        int newCapacity = source.length * 2;
        Object[] newSource = new Object[newCapacity];
        System.arraycopy(source, 0, newSource, 0, source.length);
        source = newSource;
    }

    //O(1) - the number of operations is never dependent on the number of elements in the list
    @Override
    public T get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        return (T) source[index];
    }

    //O(1) - the number of operations is never dependent on the number of elements in the list
    @Override
    public void set(int index, T value) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        source[index] = value;
    }

    ///O(n)
    @Override
    public T removeById(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        T res = (T) source[index];
        System.arraycopy(source, index + 1, source, index, size - index - 1);
        source[size - 1] = null;
        size--;
        return res;
    }

    //O(1)
    @Override
    public int size() {
        return size;
    }

    //O(n)
    @Override
    public void clear() {
        for (int i = 0; i < size; i++)
            source[i] = null;
        size = 0;
    }

    //O(n) - to find the needle and O(n) to remove it by its index-> O(n) + O(n)
    //total n of operations id O(n)
    @Override
    public boolean remove(T obj) {
        if (obj == null) { // how to escape nullPointerException
            for (int i = 0; i < size; i++) {
                if (source[i] == null) {
                    removeById(i);
                    source[size--] = null;
                    return true;
                }
            }
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (source[i].equals(obj)) {
                removeById(i);
                return true;
            }
        }
        return false;
    }
    //O(n)
    @Override
    public boolean contains(T obj) {
        if (obj == null) { // how to escape nullPointerException
            for (int i = 0; i < size; i++) {
                if (source[i] == null) {
                    removeById(i);
                    source[size--] = null;
                    return true;
                }
            }
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (source[i].equals(obj)) {
                return true;
            }
        }
        return false;
    }
    //O(n) is the complexity of use of iterator
    @Override
    public Iterator<T> forwardIterator() {
        Iterator<T> iterator = new ForwardIterator();
        return iterator;
    }
    //O(n)
    @Override
    public Iterator<T> backwardIterator() {
        Iterator<T> backwardIterator = new BackwardIterator<>((T[]) source, size);
        return backwardIterator;
    }

    @Override
    public Iterator iterator() {
        return forwardIterator();
    }


    class ForwardIterator implements Iterator<T> {
        int currentIndex = 0;


        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public T next() {
            if (currentIndex >= size) {
                throw new IndexOutOfBoundsException();
            }
            return (T) source[currentIndex++];
        }
    }

    private static class BackwardIterator<E> implements Iterator<E> {
        E[] source;
        int currentIndex;


        public BackwardIterator(E[] source, int size) {
            this.source = source;
            currentIndex = size - 1;
        }

        @Override
        public boolean hasNext() {
            return currentIndex >= 0;
        }

        @Override
        public E next() {
            if (currentIndex < 0)
                throw new IndexOutOfBoundsException();

            return source[currentIndex--];
        }
    }
}

