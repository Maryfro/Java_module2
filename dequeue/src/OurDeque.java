/**
 * The implementations of the interface should be able to work with the last and the first elements eddiciently.
 * Namely add, remove and get.
 * @param <T> the type of the elements storing in the deque
 */

public interface OurDeque<T> {
    /**
     *
     * @param el
     * @throws DequeOverflowException().
     * * If the implementation may contain limited amount of elements, then
     *      * the method throws DequeOverflowException.
     */

    void addFirst(T el);

    T getFirst();

    T removeFirst();

    void addLast(T el);

    T getLast();

    T removeLast();

    int size();
}
