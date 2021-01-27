
import map.OurTreeMap;

public class OurTreeSet<T> implements OurSet<T> {


    public OurTreeSet() {
        T source = (T) new OurTreeMap<T, Object>();
    }
}
