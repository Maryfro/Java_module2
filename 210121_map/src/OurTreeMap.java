import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class OurTreeMap<K, V> implements OurMap<K, V> {
    private final Comparator<K> keyComparator;
    private Node<K, V> root;
    private int size;


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


    @Override
    public V put(K key, V value) {
        if (key == null) {
            throw new NullPointerException();
        }
        if (root == null) { // if we have no root
            Node<K, V> node = new Node<>(null, key, value);
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
        Node<K, V> node = new Node<>(parent, key, value);// if given key is new
        if (cmp < 0)
            parent.left = node;
        else
            parent.right = node;
        size++;
        return null;
    }

    public V putVersion2(K key, V value) {
        if (key == null) {
            throw new NullPointerException();
        }
        Node<K, V> current = root;
        Node<K, V> parent = null;
        int comparator = 0;
        while (current != null) {
            parent = current;
            comparator = keyComparator.compare(key, current.key);
            if (comparator > 0)
                current = current.right;
            else if (comparator < 0)
                current = current.left;
            else {
                V res = current.value;
                current.value = value;
                return res;
            }
        }
        Node<K, V> node = new Node<>(parent, key, value);
        if (comparator > 0)
            parent.right = node;
        else if (comparator < 0)
            parent.left = node;
        else
            root = node;
        size++;
        return null;
    }


    @Override
    public V get(K key) {
        if (key == null) {
            throw new NullPointerException();
        }
        Node<K, V> current = root;
        int cmp;
        while (current != null) {
            cmp = keyComparator.compare(key, current.key);
            if (cmp < 0)
                current = current.left;
            else if (cmp > 0)
                current = current.right;
            else
                return current.value;
        }
        return null;
    }

    public V getVersion2(K key) {
        if (key == null) {
            throw new NullPointerException();
        }
        Node<K, V> current = findNode(key);
        return current == null ? null : current.value;
    }

    private Node<K, V> findNode(K key) {
        Node<K, V> current = root;
        while (current != null) {
            int cmp = keyComparator.compare(key, current.key);
            if (cmp < 0)
                current = current.left;
            else if (cmp > 0)
                current = current.right;
            else {
                return current;
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        return findNode(key) != null;
    }

    @Override
    public V remove(K key) {
        Node<K, V> nodeToRemove = findNode(key);
        if (nodeToRemove == null)
            return null;
        size--;
        if (nodeToRemove.left != null && nodeToRemove.right != null) {
            return junctionRemove(nodeToRemove);
        }
        return linearRemove(nodeToRemove);
    }

    private V junctionRemove(Node<K, V> nodeToRemove) {
        Node<K, V> nextNode = findNextInRightBranch(nodeToRemove);
        V res = nodeToRemove.value;
        nodeToRemove.key = nextNode.key;
        nodeToRemove.value = nextNode.value;
        linearRemove(nextNode);
        return res;
    }

    private Node<K, V> findNextInRightBranch(Node<K, V> nodeToRemove) {
        Node<K, V> next = nodeToRemove.right;

        while (next.left != null) {
            next = next.left;
        }

        return next;
    }

    private Node<K, V> findNextRightParent(Node<K, V> currentPair) {
        while (currentPair.parent != null && currentPair.parent.left != currentPair) {
            currentPair = currentPair.parent;
        }
        return currentPair.parent;
    }

    private V linearRemove(Node<K, V> nodeToRemove) {
        V res = nodeToRemove.value;
        if (nodeToRemove.parent == null) { //removing root
            if (nodeToRemove.right == null) {
                root = nodeToRemove.left;
            } else
                root = nodeToRemove.right;

            return res;
        }
        if (nodeToRemove.right == null && nodeToRemove.left == null) { //if nodeToRemove is a leaf
            if (nodeToRemove.parent.left != null)
                nodeToRemove.parent.left = null;
            else
                nodeToRemove.parent.right = null;
        } else {
            if (nodeToRemove.right != null)  // if nodeToRemove has one child
                nodeToRemove.parent.right = nodeToRemove.right;
            else
                nodeToRemove.parent.left = nodeToRemove.left;
        }
        return res;
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public Iterator<K> keyIterator() {
        KeyIterator iterator = new KeyIterator();
        return iterator;
    }

    private Node<K, V> findMin() {
        Node<K, V> min = root;
        while (min.left != null) {
            min = min.left;
        }
        return min;
    }

    private class KeyIterator implements Iterator<K> {
        int count = 0; // how many elements we already passed
        OurTreeMap.Node<K, V> currentPair;

        public KeyIterator() {
            if (size > 0)
                currentPair = findMin();
        }


        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public K next() {
            if (count == size)
                throw new IndexOutOfBoundsException();

            K res = currentPair.key;
            if (currentPair.right != null) { // if we have right child
                currentPair = findNextInRightBranch(currentPair);
            } else {//if we have no right child
                currentPair = findNextRightParent(currentPair);
            }
            count++;
            return res;
        }
    }


    @Override
    public Iterator<V> valueIterator() {
        ValueIterator valueIterator = new ValueIterator();
        return valueIterator;
    }

    class ValueIterator implements Iterator<V> {
        KeyIterator valIterator;

        public ValueIterator() {
            valIterator = new KeyIterator();
        }

        @Override
        public boolean hasNext() {
            return valIterator.hasNext();
        }

        @Override
        public V next() {
            if (!valIterator.hasNext())
                throw new NoSuchElementException();
            return get(valIterator.next());
        }
    }


}
