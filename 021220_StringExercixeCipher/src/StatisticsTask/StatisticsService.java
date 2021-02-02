package StatisticsTask;

import java.time.LocalTime;
import java.util.*;


// there is a list of objects with class statistics
//class StatisticsTask.Statistics has DateTime time; String url; int last10minMentions;
// for every object of statistics need to fill the field last10minMentions
//use hashmap with keys = url, values - queue like maxCoveredPoints;

public class StatisticsService {
    public static List<Statistics> listOfStatistics = new ArrayList<>();


    public int last10minutesMentions(List<Statistics> listOfStatistics) {
        HashMap<String, ArrayDeque<LocalTime>> map = new HashMap<>();
        int res = 1;
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
            res = values.size();
        }
        return res;
    }

    public static class Statistics {
        LocalTime time;
        String url;
        int last10minutesMentions;

        public Statistics(LocalTime time, String url) {
            this.time = time;
            this.url = url;
            listOfStatistics.add(this);
            StatisticsService ss = new StatisticsService();
            last10minutesMentions = ss.last10minutesMentions(listOfStatistics);
        }
    }

}
