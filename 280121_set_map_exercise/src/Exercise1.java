
import java.util.HashSet;
import java.util.List;

public class Exercise1 {

    public HashSet<Integer> getUniqueNumbers(List<Integer> list) {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.addAll(list);
        return hashSet;
    }


}

