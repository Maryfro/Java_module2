import map.OurHashMap;
import map.OurMap;
import map.OurTreeMap;

import java.util.Iterator;

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
        for (T el: another) {
            remove(el);
        }
    }

    /*default void addAll(OurSet<T> another){
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
    }*/
}
