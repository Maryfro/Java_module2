import java.time.LocalTime;
import java.util.*;

// there is a list of objects with class statistics
//class Statistics has DateTime time; String url; int last10minMentions;
// for every object of statistics need to fill the field last10minMentions
//use hashmap with keys = url, values - queue like maxCoveredPoints;


public class Statistics {
    LocalTime time;
    String url;
    int last10minutesMentions;

    public Statistics(LocalTime time, String url) {
        this.time = time;
        this.url = url;
        ArrayList<Statistics> listOfStatistics = createListOfStatistics();
        last10minutesMentions = last10minutesMentions(listOfStatistics);
    }


    public ArrayList<Statistics> createListOfStatistics() {
        ArrayList<Statistics> listOfStatistics = new ArrayList<>();
        Collections.addAll(listOfStatistics, this);
        return listOfStatistics;
    }

    public static void main(String[] args) {
       /* ArrayList<Statistics> listOfStatistics = new ArrayList<>();
        Statistics one = new Statistics(LocalTime.of(9, 0), "url1");
        Statistics two = new Statistics(LocalTime.of(9, 1), "url2");
        Statistics four = new Statistics(LocalTime.of(9, 3), "url2");
        Statistics five = new Statistics(LocalTime.of(9, 15), "url2");
        Collections.addAll(listOfStatistics, one, two, three, four, five);
        System.out.println(listOfStatistics);*/
        Statistics one = new Statistics(LocalTime.of(9, 0), "url1");
        Statistics three = new Statistics(LocalTime.of(9, 3), "url1");
        System.out.println(one.last10minutesMentions);
        System.out.println(three.last10minutesMentions);

    }

    private int last10minutesMentions(List<Statistics> listOfStatistics) {
        HashMap<String, ArrayDeque<LocalTime>> map = new HashMap<>();
            int max = 1;
        for (Statistics s : listOfStatistics) {
            ArrayDeque<LocalTime> values = map.get(s.url);
            if (values == null) {
                values = new ArrayDeque<>();
                map.put(s.url, values);
            }
            values.addLast(s.time);
            while (s.time.minusMinutes(10).isBefore(values.getFirst())) {
                values.removeFirst();
            }
            if (max < values.size()) {
                max = values.size();
            }

            System.out.println(map.keySet());
            System.out.println(map.values());
        }
        return max;
    }


}

