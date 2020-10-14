package telran.data;

public class ErrorModule implements MonitoringSystem {
    @Override
    public void start() {
        System.out.println("Error module is starting");
    }

    @Override
    public void stop() {

    }
}
