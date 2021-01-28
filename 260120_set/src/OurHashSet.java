import java.util.Iterator;

import map.OurHashMap;
import map.OurMap;


public class OurHashSet<T> extends AbstractSet<T> {

    public OurHashSet() {
        source = new OurHashMap<>();
    }


    @Override
    public void retainAll(OurSet<T> another) {
        OurSet<T> temp = new OurHashSet<>();
        for (T el : this) {
            if (!another.contains(el))
                temp.add(el);
        }
        this.removeAll(temp);
    }


}
