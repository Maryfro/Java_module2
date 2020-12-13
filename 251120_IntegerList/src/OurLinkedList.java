import java.util.Iterator;

public class OurLinkedList<T> implements IntegerList<T> {
    Node<T> first;
    Node<T> last;
    int size;

    private class Node<T> {
        Node<T> next;
        Node<T> prev;
        T element;

        public Node(Node<T> next, Node<T> prev, T element) {
            this.next = next;
            this.prev = prev;
            this.element = element;
        }

        public Node() {
        }
    }

    @Override
    public void addLast(T element) {
        Node<T> node = new Node<>(null, last, element);
        if (size == 0) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    @Override
    public T get(int index) {
        return getNodeByIndex(index).element;
    }

    @Override
    public T set(int index, T value) {
        Node<T> needle = getNodeByIndex(index);
        needle.element = value;
        return needle.element;
    }

    private Node<T> getNodeByIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> res = first;
        for (int i = 0; i < index; i++) {
            res = res.next;
        }
        return res;
    }

    @Override
    public T removeById(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            Node<T> res = first;
            first = first.next;
            first.prev = null;
            size--;
            return res.element;
        }
        if (index == size - 1) {
            Node<T> res = last;
            last = last.prev;
            last.next = null;
            size--;
            return res.element;
        }
        Node<T> res = getNodeByIndex(index);
        res.prev.next = res.next;
        res.next.prev = res.prev;
        size--;
        return res.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        if (size != 0) {
            first.next = null;
            last.prev = null;
            size = 0;
        }
    }

    @Override
    public boolean remove(T obj) {
        if (size == 0) {
            return false;
        }
        if (obj.equals(first.element)) {
            first = first.next;
            first.prev = null;
            size--;
            return true;
        }
        if (obj.equals(last.element)) {
            last = last.prev;
            last.next = null;
            size--;
            return true;
        }
        for (Node node = first.next; node != null; node = node.next) {
            if (obj.equals(node.element)) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(T obj) {
        for (Node node = first.next; node != null; node = node.next) {
            if (obj.equals(node.element)) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> forwardIterator() {
        return null;
    }

    @Override
    public Iterator<T> backwardIterator() {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }


}
