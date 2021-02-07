import java.util.List;

public class Cockroach implements Runnable {
    private final String name;
    private final int distance;
    final List<Score> scoreList;
    private long startingTime;

    public Cockroach(String name, int distance, List<Score> scoreList, long startingTime) {
        this.name = name;
        this.distance = distance;
        this.scoreList = scoreList;
        this.startingTime = startingTime;
    }

    @Override
    public void run() {
        for (int i = 0; i < distance; i++) {
            try {
                Thread.sleep(((long) (Math.random() * 50)) + 50);  //in every iteration cockroaches sleeps 50-100 ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long resTime = System.currentTimeMillis() - startingTime;
        Score score = new Score(this.name, resTime);
        scoreList.add(score);
    }
}
//   System.current time.millis - starting time
// res put in Score score-> all scores in scoreList

//after the cockroach comes to the finish, it signs up
//into the scoreList
