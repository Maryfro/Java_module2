package StatisticsTask;

import java.time.LocalTime;
import java.util.*;

public class StatisticsService {
    /**
     * the method accepts only sorted by time list of statistics
     *
     * @param listOfStatistics
     */
    public void last10minutesMentions(List<Statistics> listOfStatistics) {
        HashMap<String, ArrayDeque<LocalTime>> map = new HashMap<>();
        for (Statistics s : listOfStatistics) {
            ArrayDeque<LocalTime> values = map.get(s.url);
            if (values == null) {
                values = new ArrayDeque<>();
                map.put(s.url, values);
            }
            values.addLast(s.time);
            while (values.getFirst().isBefore(s.time.minusMinutes(10))) {
                values.removeFirst();
            }
            s.last10minutesMentions = values.size();
        }
    }
}
