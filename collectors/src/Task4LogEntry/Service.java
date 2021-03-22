package Task4LogEntry;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Service {

    public Map<String, Long> countClicksForUrl(List<LogEntry> entries) {
        return entries.stream().collect(Collectors.groupingBy(e -> e.url, Collectors.counting()));
    }

    public Map<String, Integer> countUniqueUsers(List<LogEntry> entries) {
        return entries.stream().collect(Collectors.groupingBy(LogEntry::getUrl,
                Collectors.mapping(LogEntry::getLogin,
                        Collectors.collectingAndThen(Collectors.toSet(), Set::size))));


    }


}
