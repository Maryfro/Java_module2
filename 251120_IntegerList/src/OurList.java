import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public interface OurList<T> extends Iterable<T> {

    /**
     * adds the element to the list
     *
     * @param element - to add
     */
    void addLast(T element);

    /**
     * @param index - index of element to return
     * @return element by index
     */
    T get(int index);

    /**
     * sets the value to the index place
     *
     * @param index the place to set. The index must be in range between 0 and (size-1).
     * @param value the value of the removed element
     * @return
     */
    void set(int index, T value);

    /**
     * removes the element by index
     *
     * @param index the index of the element to remove
     * @return the value of the removed element
     */
    T removeById(int index);

    /**
     * @return the size of 'this'
     */
    int size();

    void clear();

    /**
     * Method removes object if there is an element in list, which equals to the obj. The method must remove
     * only first such element.
     *
     * @param obj
     * @return true if obj was found and removed and false otherwise.
     */
    boolean remove(T obj);

    /**
     * @param obj to check
     * @return true if the object is present in the list (according to method equals)
     */
    boolean contains(T obj);

    /**
     * @return iterator object which iterates from the beginning to the end of the list
     */
    Iterator<T> forwardIterator();

    /**
     * @return iterator object which iterates from the end to the beginning of the list
     */
    Iterator<T> backwardIterator();

    /**
     * sorts elements according to the comparator rule
     *
     * @return
     */

    default void sort(Comparator<T> comparator) {
        T[] copy = (T[]) new Object[size()];
        int i = 0;
        for (T el : this) {
            copy[i++] = el;
        }
        Arrays.sort(copy, comparator);
        this.clear();
        for (Object el : copy) {
            this.addLast((T) el);
        }
    }

    default void sort() {
        T[] copy = (T[]) new Object[size()];
        int i = 0;
        for (T el : this) {
            copy[i++] = el;
        }
        Arrays.sort(copy);
        this.clear();
        for (Object el : copy) {
            this.addLast((T) el);
        }
    }


    default T max() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        T max = get(0);
        for (T el : this) {
            Comparable<T> currentEl = (Comparable<T>) el;
            if (currentEl.compareTo(max) > 0) {
                max = el;
            }
        }
        return max;
    }

    default T max(Comparator<T> comparator) {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        T max = get(0);
        for (T el : this) {
            if (comparator.compare(el, max) > 0) {
                max = el;
            }
        }
     /*   Iterator<T> iterator = new ArrayIntegerList.ForwardIterator();
        T max = iterator.next();
        while (iterator.hasNext()) {
            T currentElement = iterator.next();
            if (comparator.compare(currentElement, max) > 0) {
                max = currentElement;
            }
        }*/
        // this.sort(comparator);
        return max;
    }

    default T min(Comparator<T> comparator) {
        // this.sort(comparator);
        return max(comparator.reversed());
    }
    default T min() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        T min = get(0);
        for (T el : this) {
            Comparable<T> currentEl = (Comparable<T>) el;
            if (currentEl.compareTo(min) > 0) {
                min = el;
            }
        }
        return min;
    }
}
