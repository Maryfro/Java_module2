import operation.OperationContext;

import java.io.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        PrintWriter pw = new PrintWriter(new FileOutputStream("output.txt"));
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
        OperationContext operationContext = new OperationContext();
        Consumer cons1 = new Consumer(queue, pw, operationContext);
        Consumer cons2 = new Consumer(queue, pw, operationContext);
        Consumer cons3 = new Consumer(queue, pw, operationContext);
        Supplier supplier = new Supplier(br,queue);
        Thread cons1Thread = new Thread(cons1);
        Thread cons2Thread = new Thread(cons2);
        Thread cons3Thread = new Thread(cons3);
        Thread supplierThread = new Thread(supplier);
        supplierThread.run();
        cons1Thread.run();
        cons2Thread.run();
        cons3Thread.run();
    }
}
