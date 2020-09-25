package telran.data;

public class UserAdmin extends User {
    private String password;

    public UserAdmin(String name, int age, String password) {
        super(name, age);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
