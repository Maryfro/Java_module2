import java.util.*;

/**
 * The implementation of OurMap cannot contain null as a key.
 *
 * @param <K>
 * @param <V>
 */

public class OurMapImpl<K, V> implements OurMap<K, V> {
    private static final double DEFAULT_LOAD_FACTOR = 0.75;
    private static final int INITIAL_CAPACITY = 16;

    private Pair<K, V>[] source;
    private int size;
    private double loadFactor;
    private int capacity;
  //  private ArrayList<K> keys;

    public OurMapImpl() {
        source = new Pair[INITIAL_CAPACITY];
        capacity = INITIAL_CAPACITY;
        size = 0;
        loadFactor = DEFAULT_LOAD_FACTOR;
       // keys = createKeys();
    }

    static int hash(Object key) {
        return Math.abs(key.hashCode());
    }

    public OurMapImpl(double loadFactor) {
        this();
        this.loadFactor = loadFactor;
    }

    @Override
    public V put(K key, V value) {
        if (size >= loadFactor * capacity) {
            resize();
        }
        Pair<K, V> pair = findPair(key);
        if (pair != null) {
            V res = pair.value;
            pair.value = value;
            return res;
        }
        int index = hash(key) % capacity;
        Pair<K, V> newPair = new Pair(key, value, source[index]);
        source[index] = newPair;
        size++;
        return null;
    }

    private void resize() {
        capacity = capacity * 2;
        Pair<K, V>[] sourceNew = new Pair[capacity];
        for (int i = 0; i < source.length; i++) {
            while (source[i] != null) {
                int index = hash(source[i].key) % capacity;
                source[i].next = sourceNew[index];
                sourceNew[index] = source[i];
                source[i] = source[i].next;
            }
        }
        source = sourceNew;
    }

    private Pair<K, V> findPair(K key) {
        int index = hash(key) % capacity;
        Pair<K, V> current = source[index];
        while (current != null) {
            if (key.equals(current.key)) {
                return current;
            }
            current = current.next;
        }
        return current;
    }

    @Override
    public V get(K key) {
        Pair<K, V> pair = findPair(key);
        if (pair != null) {
            return pair.value;
        }
        return null;
    }

    @Override
    public V remove(K key) {
        if (findPair(key) == null)
            throw new NoSuchElementException();
        Pair<K, V> pair = findPair(key);
        int index = hash(key) % capacity;
        Pair<K, V> current = source[index];
        if (current == pair) { // remove from Head
            source[index] = current.next;
        } else { // remove form Middle or Tail
            while (current != null) {
                if (current.next != null && key.equals(current.next.key)) {
                    current.next = pair.next;
                    break;
                }
                current = current.next;
            }
        }
        size--;
        V value = pair.value;
        pair.value = null;
        pair.key = null;
        return value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator keyIterator() {
        ArrayList<K> keys = createKeys();
        Iterator<K> iterator = keys.iterator();
        return iterator;
    }

    private ArrayList<K> createKeys() {
        ArrayList<K> keys = new ArrayList<>();
        for (int i = 0; i < source.length; i++) {
            if (source[i] != null) {
                keys.add(source[i].key);
            }
        }
        System.out.println(keys);
        return keys;
    }

   /* class ForwardIterator implements Iterator<K> {
        int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < keys.size();
        }

        @Override
        public K next() {
            if (currentIndex >= keys.size()) {
                throw new IndexOutOfBoundsException();
            }
            return keys.get(currentIndex++);
        }
    }*/


    @Override
    public Iterator<V> valueIterator() {
        return null;
    }


    private static class Pair<K, V> {
        K key;
        V value;
        Pair<K, V> next;

        public Pair(K key, V value, Pair<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }


        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Pair<K, V> getNext() {
            return next;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    @Override
    public String toString() {
        for (Pair p : source) {
            if (p != null) {
                return Arrays.toString(source);
            }
        }
        return "";
    }
}
