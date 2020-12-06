public interface IntegerList<T>  {

    /**
     * adds the element to the list
     * @param element  - to add
     */
    void addLast(T element);

    /**
     *
     * @param index - index of element to return
     * @return element by index
     */
    T get(int index);

    /**
     * sets the value to the index place
     * @param index the place to set. The index must be in range between 0 and (size-1).
     * @param value the value of the removed element
     * @return
     */
    T set(int index, T value);

    /**
     * removes the element by index
     * @param index the index of the element to remove
     * @return the value of the removed element
     */
    T removeById(int index);

    /**
     *
     * @return the size of 'this'
     */
    int size();

    void clear();

    /**
     * Method removes object if there is an element in list, which equals to the obj. The method must remove
     * only first such element.
     * @param obj
     * @return true if obj was found and removed and false otherwise.
     */
    boolean remove(T obj);

    /**
     *
     * @param obj to check
     * @return true if the object is present in the list (according to method equals)
     */
    boolean contains(T obj);
}
