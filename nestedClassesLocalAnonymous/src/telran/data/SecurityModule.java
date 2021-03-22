package telran.data;

public class SecurityModule implements MonitoringSystem {
    @Override
    public void start() {
        System.out.println("Security Module is starting");
    }

    @Override
    public void stop() {

    }
}
