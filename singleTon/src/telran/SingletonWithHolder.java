package telran;

public class SingletonWithHolder {
private static String name;

    private SingletonWithHolder() {
    }

    public static String getName() {
        return name;
    }

    private static class SingletonHolder{
        private static final SingletonWithHolder INSTANCE = new SingletonWithHolder();
    }
    public static SingletonWithHolder getInstance(){
        SingletonWithHolder.name = "boss";
        return SingletonHolder.INSTANCE;
    }

}
