package StatisticsTask;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsServiceTest {


    @Test
    public void test_last10minutesMentions() {
        StatisticsService.Statistics one = new StatisticsService.Statistics(LocalTime.of(9, 0), "url1");
        StatisticsService.Statistics two = new StatisticsService.Statistics(LocalTime.of(9, 1), "url2");
        StatisticsService.Statistics three = new StatisticsService.Statistics(LocalTime.of(9, 3), "url1");
        StatisticsService.Statistics four = new StatisticsService.Statistics(LocalTime.of(9, 3), "url2");
        StatisticsService.Statistics five = new StatisticsService.Statistics(LocalTime.of(9, 15), "url2");
        assertEquals(1, one.last10minutesMentions);
        assertEquals(1, two.last10minutesMentions);
        assertEquals(2, three.last10minutesMentions);
        assertEquals(2, four.last10minutesMentions);
        assertEquals(1, five.last10minutesMentions);
    }

    @Test
    public void test_last10minutesMentions_exp1_differentKeys() {
        StatisticsService.Statistics one = new StatisticsService.Statistics(LocalTime.of(9, 0), "url1");
        StatisticsService.Statistics two = new StatisticsService.Statistics(LocalTime.of(9, 1), "url2");
        StatisticsService.Statistics three = new StatisticsService.Statistics(LocalTime.of(9, 3), "url3");
        StatisticsService.Statistics four = new StatisticsService.Statistics(LocalTime.of(9, 3), "url4");
        StatisticsService.Statistics five = new StatisticsService.Statistics(LocalTime.of(9, 15), "url2");
        assertEquals(1, one.last10minutesMentions);
        assertEquals(1, two.last10minutesMentions);
        assertEquals(1, three.last10minutesMentions);
        assertEquals(1, four.last10minutesMentions);
        assertEquals(1, five.last10minutesMentions);
    }

    @Test
    public void test_last10minutesMentions_anotherStatistics_exp1_greaterThen10Minutes() {
        StatisticsService.Statistics one = new StatisticsService.Statistics(LocalTime.of(8, 50), "url1");
        StatisticsService.Statistics two = new StatisticsService.Statistics(LocalTime.of(9, 1), "url1");
        StatisticsService.Statistics three = new StatisticsService.Statistics(LocalTime.of(9, 30), "url1");
        StatisticsService.Statistics four = new StatisticsService.Statistics(LocalTime.of(17, 33), "url2");
        StatisticsService.Statistics five = new StatisticsService.Statistics(LocalTime.of(17, 44), "url2");
        assertEquals(1, one.last10minutesMentions);
        assertEquals(1, two.last10minutesMentions);
        assertEquals(1, three.last10minutesMentions);
        assertEquals(1, four.last10minutesMentions);
        assertEquals(1, five.last10minutesMentions);
    }

    @Test
    public void test_last10minutesMentions_timeBeforeAndAfterFullHour() {
        StatisticsService.Statistics one = new StatisticsService.Statistics(LocalTime.of(8, 55), "url1");
        StatisticsService.Statistics two = new StatisticsService.Statistics(LocalTime.of(9, 1), "url1");
        StatisticsService.Statistics three = new StatisticsService.Statistics(LocalTime.of(9, 3), "url1");
        StatisticsService.Statistics four = new StatisticsService.Statistics(LocalTime.of(12, 51), "url2");
        StatisticsService.Statistics five = new StatisticsService.Statistics(LocalTime.of(13, 1), "url2");
        assertEquals(1, one.last10minutesMentions);
        assertEquals(2, two.last10minutesMentions);
        assertEquals(3, three.last10minutesMentions);
        assertEquals(1, four.last10minutesMentions);
        assertEquals(2, five.last10minutesMentions);
    }
}
