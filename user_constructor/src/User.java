public class User {
    private String name;
    private final int id_number;
    private static int userNumber = 0;


    public User(String name) {
        this.name = name;
        id_number = ++userNumber;
    }

    public String getName() {
        return name;
    }

    public int getId_number() {
        return id_number;
    }

    public static void main(String[] args) {
        User user1 = new User("Vasya");
        User user2 = new User("Petya");
        User user3 = new User("Kolya");
        User user4 = new User("Misha");
        System.out.println("Name: " + user1.getName() + ",  id number: " + String.format("%03d", user1.id_number));
        System.out.println("Name: " + user2.getName() + ",  id number: " + String.format("%03d", user2.getId_number()));
        System.out.println("Name: " + user3.getName() + ",  id number: " + String.format("%03d", user3.getId_number()));
        System.out.println("Name: " + user4.getName() + ",  id number: " + String.format("%03d", user4.getId_number()));



    }
}
