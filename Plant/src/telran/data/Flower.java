package telran.data;

public class Flower extends Plant {
    private final static int FLOWER_GROWTH_PER_SEASON = 40;

    public Flower(String name, int age, int height) {
        super(name, age, height);
    }

    @Override
    public int getGrowthPerSeason() {
        return FLOWER_GROWTH_PER_SEASON;
    }

    @Override
    protected void doSummer() {
        System.out.println(getName() + " is not growing in Summer, it blossoms");

    }

    @Override
    protected void doFall() {
        setHeight(2);
        System.out.println(getName() + " was cut in Fall to " + getHeight());
    }
}
