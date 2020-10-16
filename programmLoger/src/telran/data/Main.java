package telran.data;

public class Main {
    public static void main(String[] args) {
        System.out.println(ProgrammLoger.getInstance());
        System.out.println(ProgrammLoger.getInstance());
        System.out.println(ProgrammLoger.getInstance());

        ProgrammLoger.getInstance().showLogFile();
        ProgrammLoger.getInstance().addLogInfo("log one info");
        ProgrammLoger.getInstance().showLogFile();
    }
}
