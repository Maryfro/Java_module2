import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Score> scores = new ArrayList<>();
        long startingTime = System.currentTimeMillis();
        Cockroach tom = new Cockroach("Tom", 10, scores, startingTime);
        Cockroach bob = new Cockroach("Bob", 10, scores, startingTime);
        Cockroach paul = new Cockroach("Paul", 10, scores, startingTime);
        Cockroach finn = new Cockroach("Finn", 10, scores, startingTime);
        Cockroach jerry = new Cockroach("Jerry", 10, scores, startingTime);
        Thread tomThread = new Thread(tom);
        Thread bobThread = new Thread(bob);
        Thread paulThread = new Thread(paul);
        Thread finnThread = new Thread(finn);
        Thread jerryThread = new Thread(jerry);
        tomThread.start();
        bobThread.start();
        paulThread.start();
        finnThread.start();
        jerryThread.start();
        tomThread.join();
        bobThread.join();
        paulThread.join();
        finnThread.join();
        jerryThread.join();
        System.out.println(scores);
    }

}

//we have several cockroaches, and the distance
// every cm one cockroaches handles in random time (50-100millis)


