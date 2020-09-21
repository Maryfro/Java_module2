public class User {
    private String name;
    private static int id_number = 001;


    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static int getId_number() {
        id_number++;
        return id_number;
    }

    public static void main(String[] args) {
        User user1 = new User("Vasya");
        User user2 = new User("Petya");
        User user3 = new User("Kolya");
        User user4 = new User("Misha");
        System.out.println("Name: " + user1.getName() + ",  id number: " + String.format("%03d", user1.id_number));
        System.out.println("Name: " + user2.getName() + ",  id number: " + String.format("%03d", User.getId_number()));
        System.out.println("Name: " + user3.getName() + ",  id number: " + String.format("%03d", User.getId_number()));
        System.out.println("Name: " + user4.getName() + ",  id number: " + String.format("%03d", User.getId_number()));

    }
}
