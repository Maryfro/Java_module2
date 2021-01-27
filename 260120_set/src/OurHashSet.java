import java.util.Iterator;

import map.OurHashMap;


public class OurHashSet<T> implements OurSet<T> {


    public OurHashSet() {
        T source = (T) new OurHashMap<T, Object>();
    }

}
