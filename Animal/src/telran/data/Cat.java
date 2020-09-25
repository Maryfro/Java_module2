package telran.data;

public class Cat extends Pet{

    public Cat(String type, String color, String nickName, String owner) {
        super(type, color, nickName, owner);
    }

    @Override
    public void voice() {
        super.voice();
        System.out.println("miau-miau");
    }
}
