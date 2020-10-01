package telran.data;

public abstract class Plant {
    private String name;
    private int age;
    private int height;

    public Plant(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void addYearToAge() {
        this.age++;
    }

    public abstract int getGrowthPerSeason();

    public void doYear() {
        doSpring();
        doSummer();
        doFall();
        doWinter();
    }

    private void doSpring() {
        addYearToAge();
        System.out.println(getName() + "'s height at the beginning is " + getHeight());
        setHeight(getHeight() + getGrowthPerSeason());
        System.out.println(getName() + " has grown up to " + getHeight());
    }

    protected abstract void doSummer();

    protected abstract void doFall();

    private void doWinter() {
        System.out.println(getName() + " is not growing in Winter, height is " + getHeight());
    }

    @Override
    public String toString() {
        return "Plant " + name +
                ", age: " + age +
                ", height:" + height;
    }

    public void growthOfPlantForPeriod(int years){
        for (int i = 0; i < years; i++) {
            this.doYear();
            System.out.println("---------------");
        }
    }
}
