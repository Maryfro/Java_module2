
public class ArrayIntegerList implements IntegerList {
    private final static int INITIAL_CAPACITY = 16;
    private int size;
    int[] source;

    public ArrayIntegerList() {
        source = new int[INITIAL_CAPACITY];
    }

    @Override
    public void addLast(int element) {
        if (size == source.length) {
            increaseCapacity();
        }
        source[size++] = element;
    }

    void increaseCapacity() {
        int newCapacity = source.length * 2;
        int[] newSource = new int[newCapacity];
        System.arraycopy(source, 0, newSource, 0, source.length);
        source = newSource;
    }

    @Override
    public int get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        return source[index];
    }

    @Override
    public int set(int index, int value) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        source[index] = value;
        return value;
    }

    @Override
    public int removeById(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        int res = get(index);
       source[index] = source[source.length-1];
        decreaseCapacity(index);
        return res;
    }

   void decreaseCapacity(int index) {
         int newCapacity = source.length -1;
         int[] newSource = new int[newCapacity];
         System.arraycopy(source, index,  newSource, index, newCapacity - index);
    }

    @Override
    public int size() {
        return size;
    }
}
