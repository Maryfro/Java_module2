package StatisticsTask;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsServiceOldTest {

    @Test
    public void test_last10minutesMentions() {
        StatisticsServiceOld.Statistics one = new StatisticsServiceOld.Statistics(LocalTime.of(9, 0), "url1");
        StatisticsServiceOld.Statistics two = new StatisticsServiceOld.Statistics(LocalTime.of(9, 1), "url2");
        StatisticsServiceOld.Statistics three = new StatisticsServiceOld.Statistics(LocalTime.of(9, 3), "url1");
        StatisticsServiceOld.Statistics four = new StatisticsServiceOld.Statistics(LocalTime.of(9, 3), "url2");
        StatisticsServiceOld.Statistics five = new StatisticsServiceOld.Statistics(LocalTime.of(9, 15), "url2");
        assertEquals(1, one.last10minutesMentions);
        assertEquals(1, two.last10minutesMentions);
        assertEquals(2, three.last10minutesMentions);
        assertEquals(2, four.last10minutesMentions);
        assertEquals(1, five.last10minutesMentions);
    }

    @Test
    public void test_last10minutesMentions_exp1_differentKeys() {
        StatisticsServiceOld.Statistics one = new StatisticsServiceOld.Statistics(LocalTime.of(9, 0), "url1");
        StatisticsServiceOld.Statistics two = new StatisticsServiceOld.Statistics(LocalTime.of(9, 1), "url2");
        StatisticsServiceOld.Statistics three = new StatisticsServiceOld.Statistics(LocalTime.of(9, 3), "url3");
        StatisticsServiceOld.Statistics four = new StatisticsServiceOld.Statistics(LocalTime.of(9, 3), "url4");
        StatisticsServiceOld.Statistics five = new StatisticsServiceOld.Statistics(LocalTime.of(9, 15), "url2");
        assertEquals(1, one.last10minutesMentions);
        assertEquals(1, two.last10minutesMentions);
        assertEquals(1, three.last10minutesMentions);
        assertEquals(1, four.last10minutesMentions);
        assertEquals(1, five.last10minutesMentions);
    }

    @Test
    public void test_last10minutesMentions_anotherStatistics_exp1_greaterThen10Minutes() {
        StatisticsServiceOld.Statistics one = new StatisticsServiceOld.Statistics(LocalTime.of(8, 50), "url1");
        StatisticsServiceOld.Statistics two = new StatisticsServiceOld.Statistics(LocalTime.of(9, 1), "url1");
        StatisticsServiceOld.Statistics three = new StatisticsServiceOld.Statistics(LocalTime.of(9, 30), "url1");
        StatisticsServiceOld.Statistics four = new StatisticsServiceOld.Statistics(LocalTime.of(17, 33), "url2");
        StatisticsServiceOld.Statistics five = new StatisticsServiceOld.Statistics(LocalTime.of(17, 44), "url2");
        assertEquals(1, one.last10minutesMentions);
        assertEquals(1, two.last10minutesMentions);
        assertEquals(1, three.last10minutesMentions);
        assertEquals(1, four.last10minutesMentions);
        assertEquals(1, five.last10minutesMentions);
    }

    @Test
    public void test_last10minutesMentions_timeBeforeAndAfterFullHour() {
        StatisticsServiceOld.Statistics one = new StatisticsServiceOld.Statistics(LocalTime.of(8, 55), "url1");
        StatisticsServiceOld.Statistics two = new StatisticsServiceOld.Statistics(LocalTime.of(9, 1), "url1");
        StatisticsServiceOld.Statistics three = new StatisticsServiceOld.Statistics(LocalTime.of(9, 3), "url1");
        StatisticsServiceOld.Statistics four = new StatisticsServiceOld.Statistics(LocalTime.of(12, 51), "url2");
        StatisticsServiceOld.Statistics five = new StatisticsServiceOld.Statistics(LocalTime.of(13, 1), "url2");
        assertEquals(1, one.last10minutesMentions);
        assertEquals(2, two.last10minutesMentions);
        assertEquals(3, three.last10minutesMentions);
        assertEquals(1, four.last10minutesMentions);
        assertEquals(2, five.last10minutesMentions);
    }
}
