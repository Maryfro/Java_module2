package telran.data;

public class Pet extends Animal {
    private String nickName;
    private String owner;

    public Pet(String type, String color, String nickName, String owner) {
        super(type, color);
        this.nickName = nickName;
        this.owner = owner;
    }

    public String getNickName() {
        return nickName;
    }

    public String getOwner() {
        return owner;
    }

    public void play() {
        System.out.println(nickName + " plays");
    }

    public void voice() {
        System.out.println(nickName + " says: ");
    }

    public static void displayVoice(Pet pet) {
        pet.voice();
    }

    @Override
    public String toString() {
        return super.toString() +
                "nickName: " + nickName +
                ", owner: " + owner +
                ", type: " + type;
    }
}
