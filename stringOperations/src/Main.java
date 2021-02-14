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

        cons1Thread.setDaemon(true);
        cons2Thread.setDaemon(true);
        cons3Thread.setDaemon(true);

        for (Thread thread : Arrays.asList(supplierThread, cons1Thread, cons2Thread, cons3Thread)) {
            thread.start();
        }
        supplierThread.join();
        Thread.sleep(1);
        queue.add("exit");
        queue.add("exit");
        queue.add("exit");


        pw.close();
        br.close();

    }
}
