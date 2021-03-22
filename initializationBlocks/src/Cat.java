public class Cat extends Pet {

    static {
        System.out.println("static block in Cat");
    }

    {
        System.out.println("First block in Cat");
    }

    {
        System.out.println("Second block in Cat");
    }

    public Cat() {
        System.out.println("Cat empty constructor");
    }

    static void sayHello() {
        System.out.println("Hello");
    }

    void voice() {
        System.out.println("miau");
    }

}
