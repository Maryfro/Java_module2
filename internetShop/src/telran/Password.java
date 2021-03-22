package telran;


public class Password implements User.Authentication {
    private String password;
    private static int id;
    private int idNum;

    {
        idNum = ++id;
    }

    public Password() {
        password = "pass" + idNum + "word";
    }


    @Override
    public String toString() {
        return password;
    }
}
