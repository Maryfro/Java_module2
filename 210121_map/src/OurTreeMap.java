import java.util.Comparator;
import java.util.Iterator;

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
        Node<K, V> node = new Node(parent, key, value);
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
        Node<K, V> nextNode = findNext(nodeToRemove);
        V res = nodeToRemove.value;
        nodeToRemove.key = nextNode.key;
        nodeToRemove.value = nextNode.value;
        linearRemove(nextNode);
        return res;
    }

    private Node<K, V> findNext(Node<K, V> nodeToRemove) {
        Node<K, V> next = nodeToRemove.right;
        while (next != null) {
            next = next.left;
        }
        return next;
    }

    private V linearRemove(Node<K, V> nodeToRemove) {
        V res = nodeToRemove.value;
        if (nodeToRemove.parent == null) { //removing root
            if (nodeToRemove.right == null) {
                root = nodeToRemove.left;
            } else {
                root = nodeToRemove.right;
            }
            return res;
        }
        if (nodeToRemove.right == null && nodeToRemove.left == null) { //if nodeToRemove is a leaf
            if (nodeToRemove.parent.left != null)
                nodeToRemove.parent.left = null;
            else
                nodeToRemove.parent.right = null;
        } else {
            if (nodeToRemove.right != null) { // if nodeToRemove has one child
                nodeToRemove.parent.right = nodeToRemove.right;
            } else {
                nodeToRemove.parent.left = nodeToRemove.left;
            }
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

    private class KeyIterator implements Iterator<K> {
        int position = 0; // how many elements we already passed
        OurTreeMap.Node<K, V> currentPair;

        public KeyIterator() {
            if (size == 0)
                return;
            currentPair = findMin();
        }

        private Node<K, V> findMin() {
            Node<K, V> min;
            min = root;
            while (min.left != null) {
                min = min.left;
            }
            return min;
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
                if (currentPair.right != null) { // if we have right child
                    currentPair = currentPair.right;
                    while (currentPair.left != null) {
                        currentPair = currentPair.left;
                    }
                    position++;
                } else {
                    position++;
                    while (currentPair.parent != currentPair.parent.right) {
                        currentPair = currentPair.parent.right;
                    }
                    if (currentPair == currentPair.parent.left) { //if we have no right child
                        currentPair = currentPair.parent;
                    }
                }
                return currentPair.key;
        }
    }

    @Override
    public Iterator<V> valueIterator() {
        return null;
    }


}
