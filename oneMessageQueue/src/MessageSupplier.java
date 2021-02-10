import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MessageSupplier implements Runnable {
    private OneItemStringQueue queue;

    public MessageSupplier(OneItemStringQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        //TODO implement here the logic for reading from console and putting the obtained line into the queue
        //add to the queue
        try {
            readFromConsole();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void readFromConsole() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = br.readLine()) != null) {
                queue.addFirst(line);
               // System.out.println(Thread.currentThread());
            }
        }
    }
}
