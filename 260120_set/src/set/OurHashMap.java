package set;
import java.util.*;

/**
 * The implementation of OurMap cannot contain null as a key.
 *
 * @param <K>
 * @param <V>
 */

public class OurHashMap<K, V> implements OurMap<K, V> {
    private static final double DEFAULT_LOAD_FACTOR = 0.75;
    private static final int INITIAL_CAPACITY = 16;

    private Pair<K, V>[] source;
    private int size;
    private double loadFactor;
    private int capacity;
    //  private ArrayList<K> keys;

    public OurHashMap() {
        source = new Pair[INITIAL_CAPACITY];
        capacity = INITIAL_CAPACITY;
        size = 0;
        loadFactor = DEFAULT_LOAD_FACTOR;
        // keys = createKeys();
    }

    static int hash(Object key) {
        return Math.abs(key.hashCode());
    }

    public OurHashMap(double loadFactor) {
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
            Pair<K, V> current = source[i];
            while (current != null) {
                int index = hash(source[i].key) % capacity;
                Pair<K, V> next = current.next;
                current.next = sourceNew[index];
                sourceNew[index] = current;
                current = next;
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
        return pair == null ? null : pair.value;
    }

    @Override
    public V remove(K key) {
        int index = hash(key) % capacity;
        Pair<K, V> current = source[index];
        if (current == null) {
            return null;
        }
        if (current.key.equals(key)) { //remove from Head
            source[index] = current.next;
            V res = current.value;
            clearPair(current);
            size--;
            return res;
        }
        while (current.next != null) { //remove from Middle and Tail
            if (current.next.key.equals(key)) {
                Pair<K, V> pairToRemove = current.next;
                V res = pairToRemove.value;
                current.next = pairToRemove.next;
                clearPair(pairToRemove);
                size--;
                return res;
            }
            current = current.next;
        }
        return null;


      /*  if (findPair(key) == null) {
            return null;
        }
        Pair<K, V> pair = findPair(key);
        int index = hash(key) % capacity;
        Pair<K, V> current = source[index];
        if (current == pair) { // remove from Head
            source[index] = current.next;
        } else { // remove from Middle or Tail
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
        pair.next = null;
        pair.value = null;
        pair.key = null;
        return value;*/
    }

    private void clearPair(Pair<K, V> current) {
        current.key = null;
        current.value = null;
        current.next = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean containsKey(K key) {
        return findPair(key) != null;
    }

    @Override
    public Iterator keyIterator() {
        ArrayList<K> keys = createKeys();
        Iterator<K> iterator = keys.iterator();
        //KeyIterator keyIterator = new KeyIterator();
        return iterator;
    }

    private ArrayList<K> createKeys() {
        ArrayList<K> keys = new ArrayList<>();
        for (int i = 0; i < source.length; i++) {
            while (source[i] != null) {
                keys.add(source[i].key);
                source[i] = source[i].next;
            }
        }
        //System.out.println(keys);
        return keys;
    }


    @Override
    public Iterator<V> valueIterator() {
        ArrayList<V> values = new ArrayList<>();
        for (int i = 0; i < source.length; i++) {
            while (source[i] != null) {
                values.add(source[i].value);
                source[i] = source[i].next;
            }
        }
        return values.iterator();
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

    private class KeyIterator implements Iterator<K> {
        int index = 0;
        int position = 0; // how many elements we already passed
        Pair<K, V> currentPair;

        public KeyIterator() {
            if (size == 0)
                return;
            while (source[index++] == null) ;
            currentPair = source[index];
        }

        @Override
        public boolean hasNext() {
            return position < size;
        }

        @Override
        public K next() {
            if (position >= size) {
                throw new IndexOutOfBoundsException();
            }
            K res = currentPair.key;
            if (currentPair.next != null) {
                currentPair = currentPair.next;
            } else {
                do {
                    index++;
                } while (index < capacity && source[index] == null);
                currentPair = index < capacity ? source[index] : null;
            }
            position++;
            return res;
        }
    }

    /*@Override
    public Iterator<V> valueIterator() {

        return new Iterator<V>() {
            @Override
            public boolean hasNext() {
                return keyIterator().hasNext();
            }

            @Override
            public V next() {
                return get((K) keyIterator().next());
            }
        };
    }*/
}
