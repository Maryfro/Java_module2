package telran.data;

public class GeneralModule implements MonitoringSystem {
    @Override
    public void start() {
        System.out.println("General module is starting");
    }

    @Override
    public void stop() {

    }
}
