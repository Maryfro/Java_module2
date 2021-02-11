import operation.IStringOperation;
import operation.OperationContext;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private final BlockingQueue<String> queue;
    private final PrintWriter writer;
    private final OperationContext context;

    public Consumer(BlockingQueue<String> queue, PrintWriter writer, OperationContext context) {
        this.queue = queue;
        this.writer = writer;
        this.context = context;
    }

    @Override
    public void run() {
        try {
            for (String line : queue) {
                String res = handleRawString(line);
                writer.println(res);
            }
        } finally {
            writer.close();
        }
    }

    String handleRawString(String line) {
        String[] split = line.split("#");
        if (split.length != 2) {
            return line + " #wrong format";
        }
        IStringOperation operation = context.getOperation(split[1]);
        String word = split[0];
        if (operation == null) {
            return line + " #wrong operation";
        }
        return operation.operate(word);
    }
}