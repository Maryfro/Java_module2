package telran;

public class Test {
    public static String str;
    private static int id;
    private int idInstance;

    {
        System.out.println("non static block initializer");
        idInstance = ++id;
        str = "Hello world";
    }

    static {
        System.out.println("static initializer");
        str = "Hi";
    }

    public void call() {
        System.out.println("Call method");
    }

    public static void main(String[] args) {
        System.out.println(str);
        Test test = new Test();
        test.call();

        System.out.println(test.idInstance);
        Test test1 = new Test();
        System.out.println(test1.idInstance);
    }

}
