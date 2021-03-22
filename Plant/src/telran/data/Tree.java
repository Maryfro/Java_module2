package telran.data;

public class Tree extends Plant {
    public final static int TREE_GROWTH_PER_SEASON = 50;

    public Tree(String name, int age, int height) {
        super(name, age, height);
    }

    @Override
    public int getGrowthPerSeason() {
        return TREE_GROWTH_PER_SEASON;
    }

    @Override
    protected void doSummer() {
        setHeight(getHeight() + TREE_GROWTH_PER_SEASON);
        System.out.println(getName() + " has grown in Summer up to " + getHeight());
    }

    @Override
    protected void doFall() {
        setHeight(getHeight() + TREE_GROWTH_PER_SEASON / 2);
        System.out.println(getName() + " has grown in Fall up to " + getHeight());
    }
}
