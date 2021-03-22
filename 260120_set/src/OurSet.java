

public interface OurSet<T> extends Iterable<T> {

    boolean add(T el);

    boolean remove(T el);

    boolean contains(T el);

    int size();


    default void addAll(OurSet<T> another) {
        for (T el : another) {
            add(el);
        }
    }

    void retainAll(OurSet<T> another);

    default void removeAll(OurSet<T> another) {
        for (T el : another) {
            remove(el);
        }
    }
}
