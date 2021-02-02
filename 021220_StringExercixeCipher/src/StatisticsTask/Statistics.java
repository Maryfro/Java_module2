package StatisticsTask;

import java.time.LocalTime;

public class Statistics {
    LocalTime time;
    String url;
    int last10minutesMentions;

    public Statistics(LocalTime time, String url) {
        this.time = time;
        this.url = url;
    }
}

