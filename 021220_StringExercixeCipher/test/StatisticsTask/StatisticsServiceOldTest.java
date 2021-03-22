package StatisticsTask;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsServiceOldTest {
    List<StatisticsTask.Statistics> listOfStatistics = new ArrayList<>();
    StatisticsService ss = new StatisticsService();

    @Test
    public void test_last10minutesMentions() {
        Statistics one = new Statistics(LocalTime.of(9, 0), "url1");
        Statistics two = new Statistics(LocalTime.of(9, 1), "url2");
        Statistics three = new Statistics(LocalTime.of(9, 3), "url1");
        Statistics four = new Statistics(LocalTime.of(9, 3), "url2");
        Statistics five = new Statistics(LocalTime.of(9, 15), "url2");
        Collections.addAll(listOfStatistics, one, two, three, four, five);
        ss.last10minutesMentions(listOfStatistics);
        assertEquals(1, one.last10minutesMentions);
        assertEquals(1, two.last10minutesMentions);
        assertEquals(2, three.last10minutesMentions);
        assertEquals(2, four.last10minutesMentions);
        assertEquals(1, five.last10minutesMentions);
    }

    @Test
    public void test_last10minutesMentions_exp1_differentKeys() {
        Statistics one = new Statistics(LocalTime.of(9, 0), "url1");
        Statistics two = new Statistics(LocalTime.of(9, 1), "url2");
        Statistics three = new Statistics(LocalTime.of(9, 3), "url3");
        Statistics four = new Statistics(LocalTime.of(9, 3), "url4");
        Statistics five = new Statistics(LocalTime.of(9, 15), "url2");
        Collections.addAll(listOfStatistics, one, two, three, four, five);
        ss.last10minutesMentions(listOfStatistics);
        assertEquals(1, one.last10minutesMentions);
        assertEquals(1, two.last10minutesMentions);
        assertEquals(1, three.last10minutesMentions);
        assertEquals(1, four.last10minutesMentions);
        assertEquals(1, five.last10minutesMentions);
    }

    @Test
    public void test_last10minutesMentions_anotherStatistics_exp1_greaterThen10Minutes() {
        Statistics one = new Statistics(LocalTime.of(8, 50), "url1");
        Statistics two = new Statistics(LocalTime.of(9, 1), "url1");
        Statistics three = new Statistics(LocalTime.of(9, 30), "url1");
        Statistics four = new Statistics(LocalTime.of(17, 33), "url2");
        Statistics five = new Statistics(LocalTime.of(17, 44), "url2");
        Collections.addAll(listOfStatistics, one, two, three, four, five);
        ss.last10minutesMentions(listOfStatistics);
        assertEquals(1, one.last10minutesMentions);
        assertEquals(1, two.last10minutesMentions);
        assertEquals(1, three.last10minutesMentions);
        assertEquals(1, four.last10minutesMentions);
        assertEquals(1, five.last10minutesMentions);
    }

    @Test
    public void test_last10minutesMentions_timeBeforeAndAfterFullHour() {
        Statistics one = new Statistics(LocalTime.of(8, 55), "url1");
        Statistics two = new Statistics(LocalTime.of(9, 1), "url1");
        Statistics three = new Statistics(LocalTime.of(9, 3), "url1");
        Statistics four = new Statistics(LocalTime.of(12, 51), "url2");
        Statistics five = new Statistics(LocalTime.of(13, 1), "url2");
        Collections.addAll(listOfStatistics, one, two, three, four, five);
        ss.last10minutesMentions(listOfStatistics);
        assertEquals(1, one.last10minutesMentions);
        assertEquals(2, two.last10minutesMentions);
        assertEquals(3, three.last10minutesMentions);
        assertEquals(1, four.last10minutesMentions);
        assertEquals(2, five.last10minutesMentions);
    }
}
