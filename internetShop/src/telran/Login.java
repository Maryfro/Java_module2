package telran;

public class Login implements User.Authentication {
    private String login;
    private static int id;
    private int idNum;

    {
        idNum = ++id;
    }

    public Login() {
        login = "user" + idNum;
    }

    @Override
    public String toString() {
        return login;
    }
}
