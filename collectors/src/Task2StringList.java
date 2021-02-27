import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Task2StringList {
    List<String> list;

    public Task2StringList(List<String> list) {
        this.list = list;
    }

    public Map<Boolean, List<String>> mapPalindroms() {
        Predicate<String> p = word -> word.equals(new StringBuilder(word).reverse().toString());
        return list.stream().collect(Collectors.partitioningBy(p));
    }
}
