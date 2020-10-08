package telran;

public class Dog {
    private String name;
    private int age;

    static {
        System.out.println("world");
    }

    {
        name = "Sharik";
        age = 5;

        System.out.println("hello");
    }

    public Dog(){};

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Dog dog = new Dog();

        Dog dog1 = new Dog ("Bobik", 4);
        System.out.println(dog.name);
        System.out.println(dog1.name);

    }
}
