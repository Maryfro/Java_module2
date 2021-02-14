import operation.IStringOperation;
import operation.OperationContext;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private final BlockingQueue<String> queue;
    private final PrintWriter writer;
    private final OperationContext context;
    private final static String SEPARATOR = "#";
    private final static String WRONG_OPERATION = "wrong operation";
    private final static String WRONG_FORMAT = "wrong format";

    public Consumer(BlockingQueue<String> queue, PrintWriter writer, OperationContext context) {
        this.queue = queue;
        this.writer = writer;
        this.context = context;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String line = queue.take();
                if (line.equals("exit")) {
                    queue.remove("exit");
                    Thread.currentThread().interrupt();
                }
                String res = handleRawString(line);
                writer.println(res);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //TODO test with mocking!
    public String handleRawString(String line) {
        String[] split = line.split(SEPARATOR);
        if (split.length != 2) {
            return line + SEPARATOR + WRONG_FORMAT;
        }
        String word = split[0];
        IStringOperation operation = context.getOperation(split[1]);
        if (operation == null) {
            return line + SEPARATOR + WRONG_OPERATION;
        }
        return operation.operate(word);
    }
}