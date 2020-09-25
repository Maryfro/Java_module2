package telran.data;

public class WildAnimal extends Animal {
    private String habitat;

    public WildAnimal(String type, String color, String habitat) {
        super(type, color);
        this.habitat = habitat;
    }

    public String getHabitat() {
        return habitat;
    }

    public void migration(String newHabitat) {
        habitat = newHabitat;
        System.out.println(type + " is going to " + habitat);
    }

    @Override
    public void run() {
        System.out.println(type + " can run faster");
    }
}
