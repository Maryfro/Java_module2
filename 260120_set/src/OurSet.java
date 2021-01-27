public interface OurSet<T> extends Iterable<T>{
    boolean add(T el);

    boolean remove(T el);

    boolean contains(T el);

    int size();

    void addAll(OurSet<T> another);

    void retainAll(OurSet<T> another);

    void removeAll(OurSet<T> another);
}
