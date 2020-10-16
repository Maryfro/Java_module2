package telran.data;

public class ProgrammLoger {
    private static ProgrammLoger pg;
    private static String logFile;

    private ProgrammLoger() {
        logFile = "this is logfile \n";
    }

    public static ProgrammLoger getInstance() {
        if (pg == null) {
            pg = new ProgrammLoger();
        }
        return pg;
    }

    public void addLogInfo(String logInfo){
        logFile += logInfo + "\n";
    }

    public void showLogFile(){
        System.out.println(logFile);
    }

}
