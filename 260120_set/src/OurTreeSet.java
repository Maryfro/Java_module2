
import map.OurHashMap;
import map.OurMap;
import map.OurTreeMap;

import java.util.Iterator;

public class OurTreeSet<T> extends AbstractSet<T> {


    public OurTreeSet() {
        source = new OurTreeMap<>();
    }


    @Override
    public void retainAll(OurSet<T> another) {
        OurSet<T> temp = new OurTreeSet<>();
        for (T el: this) {
            if(!another.contains(el))
                temp.add(el);
        }
        this.removeAll(temp);
    }





}
