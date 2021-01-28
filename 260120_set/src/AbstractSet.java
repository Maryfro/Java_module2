import map.OurMap;

import java.util.Iterator;

abstract public class AbstractSet<T> implements OurSet<T> {
    OurMap<T, Object> source;
    Object stubValue = new Object();


    @Override
    public boolean add(T el) {
        return source.put(el, stubValue) == null;
    }

    @Override
    public boolean remove(T el) {
        return source.remove(el) != null;
    }

    @Override
    public boolean contains(T el) {
        return source.containsKey(el);
    }

    @Override
    public int size() {
        return source.size();
    }


    @Override
    public Iterator<T> iterator() {
        return source.keyIterator();
    }
}
