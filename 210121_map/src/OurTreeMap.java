import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class OurTreeMap<K, V> implements OurMap<K, V> {

    private static class Node<K, V> {
        Node<K, V> left;
        Node<K, V> right;
        Node<K, V> parent;
        K key;
        V value;

        public Node(Node<K, V> parent, K key, V value) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }
    }

    private final Comparator<K> keyComparator;
    private Node<K, V> root;
    private int size;

    public OurTreeMap(Comparator<K> keyComparator) {
        this.keyComparator = keyComparator;
    }

    /**
     * If we use this constructor in the client code, that means that the keys are Comparable
     */
    public OurTreeMap() {
        this.keyComparator = new Comparator<K>() {
            @Override
            public int compare(K o1, K o2) {
                Comparable<K> compO1 = (Comparable<K>) o1; //could be class cast exception
                return compO1.compareTo(o2);
            }
        };
    }

    /*private Node<K,V> findNode(K key){
        if(root==null){
            return null;
        }
        return;
    }*/

    @Override
    public V put(K key, V value) {
        if (root == null) { // if we have no root
            Node<K, V> node = new Node(null, key, value);
            root = node;
            size++;
            return null;
        }
        int cmp;
        Node<K, V> parent;
        Node<K, V> current = root;
        do {
            parent = current;
            cmp = keyComparator.compare(key, current.key);
            if (cmp < 0)
                current = current.left;
            else if (cmp > 0)
                current = current.right;
            else {// if we already have given key and want to replace value
                V res = current.value;
                current.value = value;
                return res;
            }
        } while (current != null);
        Node<K, V> node = new Node(parent, key, value);// if given key is new
        if (cmp < 0) {
            parent.left = node;
        } else
            parent.right = node;
        size++;
        return null;
    }


    @Override
    public V get(K key) {
        if (key == null) {
            throw new NullPointerException();
        }
        Node<K, V> current = root;
        while (current != null) {
            int cmp = keyComparator.compare(key, current.key);
            if (cmp < 0)
                current = current.left;
            else if (cmp > 0)
                current = current.right;
            else
                return current.value;
        }
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<K> keyIterator() {
        return null;
    }

    @Override
    public Iterator<V> valueIterator() {
        return null;
    }


}
