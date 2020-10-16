package telran;

public class SingletonOne {
    private static final SingletonOne INSTANCE = new SingletonOne();
    private static final String Name = "Boss";

    private SingletonOne() {
    }

    public static SingletonOne getINSTANCE() {
        return INSTANCE;
    }

    public static String getName() {
        return Name;
    }


}
