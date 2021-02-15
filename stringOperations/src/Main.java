import operation.OperationContext;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, InterruptedException {

        ConfigReader configReader = new ConfigReader("config.props");
        ArrayList<String> operationPath = (ArrayList<String>) configReader.getOperationPath();
        OperationContext operationContext = new OperationContext(operationPath);

        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        PrintWriter pw = new PrintWriter(new FileOutputStream("output.txt"));
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(20);

        Thread cons1Thread = new Thread(new Consumer(queue, pw, operationContext));
        Thread cons2Thread = new Thread(new Consumer(queue, pw, operationContext));
        Thread cons3Thread = new Thread(new Consumer(queue, pw, operationContext));
        Thread supplierThread = new Thread(new Supplier(br, queue));


        for (Thread thread : Arrays.asList(supplierThread, cons1Thread, cons2Thread, cons3Thread)) {
            thread.start();
        }

        //Wait until supplier completes
        supplierThread.join();

        //signal to the consumers that no new elements will appear in the queue
        cons1Thread.interrupt();
        cons2Thread.interrupt();
        cons3Thread.interrupt();

        //Wait until consumers complete handling the remaining elements
        cons1Thread.join();
        cons2Thread.join();
        cons3Thread.join();

        pw.close();
        br.close();

    }
}
