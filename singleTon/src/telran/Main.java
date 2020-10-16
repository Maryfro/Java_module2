package telran;

public class Main {
    public static void main(String[] args) {
        System.out.println(SingletonOne.getName());
        SingletonOne s1 = SingletonOne.getINSTANCE();
        LazySingleton ls = LazySingleton.getInstance("Boss");
        System.out.println(ls.getName());

        LazySingleton ls1 = LazySingleton.getInstance("Big Boss");// object was not created
        System.out.println(ls == ls1);

        System.out.println();

        SingletonWithHolder boss = SingletonWithHolder.getInstance();
        System.out.println(SingletonWithHolder.getName());
    }
}
