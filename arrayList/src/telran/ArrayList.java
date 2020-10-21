package telran;

public class ArrayList<E> implements CustomList<E> {
    private Object[] source;
    private int size;
    private static final int DEFAULT_CAPACITY = 5;

    public ArrayList() {
        source = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E o) {
        if (size == source.length) {
            Object[] newSource = new Object[size + DEFAULT_CAPACITY];
            System.arraycopy(source, 0, newSource, 0, source.length);
            source = newSource;
        }
        source[size++] = o;

    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (E) source[index];
    }

    @Override
    public E removeById(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Object o = (E) source[index];
        System.arraycopy(source, index + 1, source, index, size - index - 1);
        source[size--] = null;
        return (E) o;
    }

    @Override
    public boolean remove(E e) {
        for (int i = 0; i < size; i++) {
            if (source[i].equals(e)) {
                System.arraycopy(source, i + 1, source, i, size - i - 1);
                source[size--] = null;
                return true;
            }
        }
        return false;
    }

    public int indexOf(E e) {
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (source[i].equals(e)) {
                index = i;
            }
        }
        if (index > 0) return index;
        else return -1;
    }
}
