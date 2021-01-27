import map.OurHashMap;
import map.OurMap;
import map.OurTreeMap;

import java.util.Iterator;

public interface OurSet<T> extends Iterable<T> {
    OurMap<T, Object> source = new Object();
    Object stubValue = new Object();

    default boolean add(T el) {
        if (source.containsKey(el))
            return false;
        source.put(el, stubValue);
        return true;
    }

    default boolean remove(T el) {
        if (!source.containsKey(el))
            return false;
        source.remove(el);
        return true;
    }

    default boolean contains(T el) {
        return source.containsKey(el);
    }

    default int size(){
        return source.size();
    }

    default void addAll(OurSet<T> another){
        for (T el : another) {
            source.put(el, stubValue);
        }
    }

    default void retainAll(OurSet<T> another){
       Iterator<T> it = source.keyIterator();
       while(it.hasNext()){
           if(!another.contains(it.next()))
               source.remove(it.next());
       }

    }

    default void removeAll(OurSet<T> another){
        Iterator<T> it = source.keyIterator();
        while(it.hasNext()){
            if(another.contains(it.next()))
                source.remove(it.next());
        }
    }

    default Iterator<T> iterator() {
        return source.keyIterator();
    }
}
