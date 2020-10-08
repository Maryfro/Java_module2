package data;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrackingServiceTest {
    TrackingService ts = new TrackingService(10);

    @Test
    public void addCaloriesToTotal() {
        ts.addCalories(100);
        int total = ts.getTotal();
        assertEquals(100, total);
    }

    @Test
    public void addHistoryItem() {
        ts.addCalories(30);
        int historyNum = ts.getHistoryNum();
        assertEquals(1, historyNum);
    }

    @Test
    public void createHistoryItem() {
        ts.addCalories(29);
        History itemExpected = new History(29, "add calories", 1, 29);
        History itemActual = ts.getHistory()[0];
        assertEquals(itemExpected, itemActual);
    }

    @Test
    public void trackingServiceHistoryLength() {
        int historyLength = ts.getHistory().length;
        assertEquals(10, historyLength);
    }

    @Test
    public void newTrackingTotalIsZero() {
        assertEquals(0, ts.getTotal());
    }

    @Test
    public void removeCaloriesFromTotal() {
        ts.addCalories(100);
        ts.removeCalories(50);
        assertEquals(50, ts.getTotal());
    }

    @Test
    public void removeCaloriesNonNegative() {
        ts.removeCalories(50);
        assertEquals(0, ts.getTotal());
    }

    @Test
    public void notNullInHistoryByRemoving() {
        ts.removeCalories(30);
        assertNotNull(ts.getHistory()[0]);
    }

    @Test
    public void checkTotalValueAfterMultipleOperations() {
        ts.addCalories(100);
        ts.addCalories(50);
        ts.removeCalories(30);
        assertEquals(120, ts.getTotal());
    }

    @Test
    public void checkHistoryNumAfterMultipleOperations() {
        ts.addCalories(100);
        ts.addCalories(50);
        ts.removeCalories(30);
        ts.displayHistory();
        assertEquals(3, ts.getHistoryNum());
    }

    @Test
    public void checkGoalTrueCase() {
        ts.setGoal(300);
        ts.addCalories(500);
        ts.removeCalories(200);
        assertTrue(ts.checkGoal());
    }

    @Test
    public void checkGoalFalseCase() {
        ts.setGoal(300);
        ts.addCalories(500);
        assertFalse(ts.checkGoal());
    }


}