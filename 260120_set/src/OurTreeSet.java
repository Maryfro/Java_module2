import java.util.Iterator;

import set.OurTreeMap;

public class OurTreeSet<T> implements OurSet<T> {
    private OurTreeMap<T, Object> source;
    private final Object stubValue = new Object();

    public OurTreeSet() {
        source = new OurTreeMap<>();
    }

    @Override
    public boolean add(T el) {
        if (this.contains(el))
            return false;
        source.put(el, stubValue);
        return true;
    }

    @Override
    public boolean remove(T el) {
        if (!this.contains(el))
            return false;
        source.remove(el);
        return true;
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
    public void addAll(OurSet<T> another) {
        for (T el : another) {
            this.add(el);
        }
    }

    @Override
    public void retainAll(OurSet<T> another) {
        for (T el : this) {
            if (!another.contains(el))
                this.remove(el);
        }
    }

    @Override
    public void removeAll(OurSet<T> another) {
        for (T el : another) {
            if (this.contains(el))
                this.remove(el);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return source.keyIterator();
    }
}
