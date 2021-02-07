public class Score {

    String name;
    long score; // amount of millis for distance

    public Score(String name, long score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
