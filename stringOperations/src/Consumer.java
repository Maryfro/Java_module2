import operation.IStringOperation;
import operation.OperationContext;

import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private final BlockingQueue<String> queue;
    private final PrintWriter writer;
    private final OperationContext context;
    public final static String SEPARATOR = "#";
    public final static String WRONG_OPERATION = "wrong operation";
    public final static String WRONG_FORMAT = "wrong format";

    public Consumer(BlockingQueue<String> queue, PrintWriter writer, OperationContext context) {
        this.queue = queue;
        this.writer = writer;
        this.context = context;
    }

    @Override
    public void run() {
        boolean isAlive = true;

       //supplier and consumer are working
        while (isAlive ) {
            try {
                String line = queue.take();
                String res = handleRawString(line);
                writer.println(res);
            } catch (InterruptedException e) {
                isAlive = false;
            }
        }

        //supplier is already finished, consumer has to write the remaining lines from queue

       while (true) {
            String line;
            try{
                line = queue.remove();
            } catch(NoSuchElementException e){
               // e.printStackTrace();
                break;
            }
            String res = handleRawString(line);
            writer.println(res);
        }
    }

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