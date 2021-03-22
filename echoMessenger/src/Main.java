import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        //how to access a thread
        //Thread.currentThread();


        Echo echo = new Echo();
        Thread echoThread = new Thread(echo);
        //forces stop the echo thread when the main thread completes
        echoThread.setDaemon(true);
        echoThread.start();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = br.readLine()) != null && !line.equals("exit")) {
                echo.setMessage(line);
                echoThread.interrupt();
            }
        }
    }
}
