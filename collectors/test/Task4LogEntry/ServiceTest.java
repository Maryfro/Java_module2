package Task4LogEntry;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {
    Service s = new Service();

    @Test
    public void test_countClicksForUrl() {

        Map<String, Long> exp = new HashMap<>();
        exp.put("google.com", 2L);
        exp.put("boogle.com", 1L);
        List<LogEntry> entries = Arrays.asList(
                new LogEntry(System.currentTimeMillis(), "admin", "google.com"),
                new LogEntry(System.currentTimeMillis(), "hacker", "google.com"),
                new LogEntry(System.currentTimeMillis(), "somebody", "boogle.com"));
        assertEquals(exp.values().toString(), s.countClicksForUrl(entries).values().toString());
    }

    @Test
    void countUniqueUsers() {
        Map<String, Integer> exp = new HashMap<>();
        exp.put("google.com", 2);
        exp.put("boogle.com", 1);

        List<LogEntry> entries = Arrays.asList(new LogEntry(System.currentTimeMillis(), "admin", "google.com"),
                new LogEntry(System.currentTimeMillis(), "hacker", "google.com"),
                new LogEntry(System.currentTimeMillis(), "admin", "google.com"),
                new LogEntry(System.currentTimeMillis(), "somebody", "boogle.com"),
                new LogEntry(System.currentTimeMillis(), "somebody", "boogle.com"),
                new LogEntry(System.currentTimeMillis(), "somebody", "boogle.com"));

        assertEquals(exp.values().toString(), s.countUniqueUsers(entries).values().toString());
    }

}
