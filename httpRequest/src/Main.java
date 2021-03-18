import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
        //   httpConnectLowLevel();
        httpConnectHighLevel();

    }

    public static void httpConnectHighLevel() throws IOException {
        URL url = new URL("http://dev.phonebook-1.telran-edu.de:80");
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
    }

    public static void httpConnectLowLevel() throws IOException {
        Socket socket = new Socket("dev.phonebook-1.telran-edu.de", 80);

        PrintStream socketOut = new PrintStream(socket.getOutputStream());
        BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        socketOut.println("GET / HTTP/1.1");
        socketOut.println("Host: www.dev.phonebook-1.telran-edu.de");
        socketOut.println();

        String line;
        while ((line = socketIn.readLine()) != null) {
            System.out.println(line);
        }
    }
}
