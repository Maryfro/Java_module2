import java.util.Comparator;
import java.util.Iterator;

public class OurLinkedList<T> implements OurList<T> {
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
    public void set(int index, T value) {
        Node<T> needle = getNodeByIndex(index);
        needle.element = value;
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

    private T removeNode(Node<T> needle) {
        Node<T> before = needle.prev;
        Node<T> after = needle.next;
        if (before != null) {
            before.next = after;
        } else {
            first = after;
        }
        if (after != null) {
            after.prev = before;
        } else {
            last = before;
        }
        //clear the removing element
        needle.prev = needle.next = null;
        T res = needle.element;
        needle.element = null;
        size--;
        return res;

    }

    @Override
    public T removeById(int index) {
        Node<T> needle = getNodeByIndex(index);
        return removeNode(needle);
    }

    @Override
    public boolean remove(T obj) {
        Node<T> needle = findByElement(obj);
        if (needle == null) {
            return false;
        }
        removeNode(needle);
        return true;
    }

    /**
     * @param obj
     * @return null if not found; return Node otherwise
     */
    private Node<T> findByElement(T obj) {
        Node<T> res = first;
        if (obj == null) {
            //  for (int i = 0; i < size; i++) {
            while (res != null) {
                if (res.element == null) {
                    return res;
                }
                res = res.next;
            }
        } else {
            while (res != null) {
                if (obj.equals(res.element)) {
                    return res;
                }
                res = res.next;
            }
        }
        return null;
    }

    @Override
    public boolean contains(T obj) {
        return findByElement(obj) != null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first = last = null;
        size = 0;
    }


    @Override
    public Iterator<T> forwardIterator() {
        ForwardIterator fi = new ForwardIterator();
        return fi;
    }

    @Override
    public Iterator<T> backwardIterator() {
        BackwardIterator bi = new BackwardIterator();
        return bi;
    }


    @Override
    public Iterator<T> iterator() {
        return forwardIterator();
    }

    //Do not use list.get(id) method
    class ForwardIterator implements Iterator<T> {
        Node<T> currentNode = first;

        @Override
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

    class BackwardIterator implements Iterator<T> {
        Node<T> currentNode = last;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            if (currentNode == null) {
                throw new IndexOutOfBoundsException();
            }
            T res = currentNode.element;
            currentNode = currentNode.prev;
            return res;
        }
    }

    @Override
    public void sort(Comparator<T> comparator) {
        Object[] copy = new Object[size];
        int i = 0;
        for (T el : this) {
            copy[i++] = el;
        }
        for (int j = 0; j < copy.length; j++)
            for (int k = 1; k < (copy.length-j); k++)
                if (comparator.compare(getNodeByIndex(k-1).element, getNodeByIndex(k).element) > 0)
                {
                    Object temp = copy[k-1];
                    copy[k-1] = copy[k];
                    copy[k] = temp;
                }
        this.clear();
        for (Object el : copy) {
            this.addLast((T) el);
        }
    }
// for(int i=0; i < n; i++){
//                 for(int j=1; j < (n-i); j++){
//                          if(arr[j-1] > arr[j]){
//                                 //swap elements
//                                 temp = arr[j-1];
//                                 arr[j-1] = arr[j];
//                                 arr[j] = temp;
//                         }


   /* private void bubbleSort(Object[] arrUnsort,Comparator<T> comparator) {
        int count = 0;
        for (int i = 0; i < arrUnsort.length - 1; i++)
            if (comparator.compare(getNodeByIndex(i).element, getNodeByIndex(i + 1).element) > 0) {
               Object temp = arrUnsort[i];
                arrUnsort[i] = arrUnsort[i + 1];
                arrUnsort[i + 1] = temp;
                count++;
            }
        if (count > 0) {
            bubbleSort(arrUnsort, comparator);
        }
    }*/
}
