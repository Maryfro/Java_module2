import java.util.Arrays;
import java.util.Iterator;

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

    public OurMapImpl() {
        source = new Pair[INITIAL_CAPACITY];
        capacity = INITIAL_CAPACITY;
        size = 0;
        loadFactor = DEFAULT_LOAD_FACTOR;
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
            size++;
            return res;
        }
        int index = hash(key) % capacity;
        Pair<K, V> newPair = new Pair(key, value, source[index]);
        source[index] = newPair;
        size++;
        return null;
    }

    private void resize() {
        int capacityNew = capacity * 2;
        Pair<K, V>[] sourceNew = new Pair[capacityNew];
        for (int i = 0; i < capacityNew; i++) {
            int index = hash(source[i]) % capacityNew;
            sourceNew[index] = source[i];
        }
        System.out.println("new source" + Arrays.toString(sourceNew));
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
        Pair<K, V> pair = findPair(key);
        if (pair != null) {
            V res = pair.value;
            if (pair != source[0]) {
                Pair<K, V> pairPrev = source[(hash(key) % capacity) - 1];
                if (pairPrev != null) {
                    pairPrev.next = pair.next;
                }
            }
            pair.key = null;
            size--;
            return res;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator keyIterator() {
        // MyIterator keyIterator = new MyIterator();
        return null;
    }

    @Override
    public Iterator<V> valueIterator() {
        return null;
    }

   /* class MyIterator implements Iterator {
        Pair<K,V> current = source[0];

     /*   @Override
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
    }

    }*/

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
