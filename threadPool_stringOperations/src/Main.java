import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, InterruptedException {

        ConfigReader configReader = new ConfigReader("config.props");
        List<String> operationPaths = configReader.getOperationPaths();
        OperationContext operationContext = new OperationContext(operationPaths);

        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileOutputStream("output.txt"));

        ExecutorService executor = Executors.newFixedThreadPool(17);
        Supplier supplier = new Supplier(br, writer, executor, operationContext);

        Thread supplierThread = new Thread(supplier);
        supplierThread.start();
        supplierThread.join();

        executor.shutdown();// stops consuming tasks from the queue
        executor.awaitTermination(10, TimeUnit.SECONDS);// waits for the tasks from the queue to be executed

        writer.close();


    }
}
       /* ExecutorService executor = Executors.newFixedThreadPool(17);


        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("my task");
            }
        };
        Runnable task1 = () -> System.out.println("lambda");
        task1.run(); //lambda will be printed

        executor.execute(task);

        //Declines all new tasks via method execute and completes all existing tasks
        executor.shutdown();
       // ThreadPoolExecutor pool = new ThreadPoolExecutor(10);*/
