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
        return list.stream().collect(Collectors.partitioningBy(this::isPalindrom));
    }

    private boolean isPalindrom(String text) {
        StringBuilder sb = new StringBuilder(text);
        return text.equals(sb.reverse().toString());
    }
}
