package telran.data;

public class Dog extends Pet {
    public Dog(String type, String color, String nickName, String owner) {
        super(type, color, nickName, owner);
    }

    public void bark() {
        System.out.println("I can bark");
    }

    public void voice() {
        super.voice();
        System.out.println("wau-wau");
    }

    public void sleep() {
        System.out.println("I sleep 8 hours");
    }

    public void displayInfo(String color) {
        super.type = "dog";
        System.out.println("I am a " + type);
        super.setColor(color);
        System.out.println("My color is " + super.getColor());
    }


}
