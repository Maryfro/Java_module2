package Task4LogEntry;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Service {

    public Map<String, Long> countClicksForUrl(List<LogEntry> entries) {
        return entries.stream().collect(Collectors.groupingBy(e -> e.url, Collectors.counting()));
    }

    public Map<String, Map<String, Long>> countUniqueUsers(List<LogEntry> entries) {
       return entries.stream().collect(Collectors.groupingBy(e -> e.url,
                Collectors.groupingBy(e->e.login, Collectors.counting()))) ;


    }

    public static void main(String[] args) {

        List<LogEntry> entries = Arrays.asList(
                new LogEntry(System.currentTimeMillis(), "admin", "google.com"),
                new LogEntry(System.currentTimeMillis(), "hacker", "google.com"),
                new LogEntry(System.currentTimeMillis(), "boss", "google.com"),
                new LogEntry(System.currentTimeMillis(), "somebody", "boogle.com"));
        System.out.println(entries.stream().collect(Collectors.groupingBy(e -> e.url)).values());
    }
}
