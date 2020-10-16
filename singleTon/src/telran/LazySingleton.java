package telran;

public class LazySingleton {
    private static LazySingleton instance;
    private String name;

    private LazySingleton() {
    }

    public static LazySingleton getInstance(String name){
        if(instance==null){
            instance= new LazySingleton();
            instance.name = name;
        }
        return instance;
    }

    public String getName() {
        return name;
    }
}
