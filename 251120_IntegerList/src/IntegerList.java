public interface IntegerList {

    /**
     * adds the element to the list
     * @param element  - to add
     */
    void addLast(int element);

    /**
     *
     * @param index - index of element to return
     * @return element by index
     */
    int get(int index);

    /**
     * sets the value to the index place
     * @param index the place to set. The index must be in range between 0 and (size-1).
     * @param value the value of the removed element
     * @return
     */
    int set(int index, int value);

    /**
     * removes the element by index
     * @param index the index of the element to remove
     * @return the value of the removed element
     */
    int removeById(int index);

    /**
     *
     * @return the size of 'this'
     */
    int size();
}
