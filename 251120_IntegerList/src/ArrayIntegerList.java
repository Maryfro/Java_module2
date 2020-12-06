import java.util.Arrays;
import java.util.Objects;

public class ArrayIntegerList<T> implements IntegerList<T> {
    private final static int INITIAL_CAPACITY = 16;
    private int size;
    Object[] source;

    public ArrayIntegerList() {
        source = new Object[INITIAL_CAPACITY];
    }

    @Override
    public void addLast(T element) {
        if (size == source.length) {
            increaseCapacity();
        }
        source[size++] = element;
    }

    void increaseCapacity() {
        int newCapacity = source.length * 2;
        Object[] newSource = new Object[newCapacity];
        System.arraycopy(source, 0, newSource, 0, source.length);
        source = newSource;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        return (T) source[index];
    }

    @Override
    public T set(int index, T value) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        source[index] = value;
        return value;
    }

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


    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++)
            source[i] = null;
        size = 0;
    }

    @Override
    public boolean remove(T obj) {
        for (int i = 0; i < size; i++) {
            // if (source[i].equals(obj)) {
            if (this.contains(obj)) {
                System.arraycopy(source, i + 1, source, i, size - i - 1);
                source[size--] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(T obj) {
        for (int i = 0; i < size; i++) {
            if (source[i].equals(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayIntegerList<?> that = (ArrayIntegerList<?>) o;
        return size == that.size &&
                Arrays.equals(source, that.source);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(source);
        return result;
    }
}
