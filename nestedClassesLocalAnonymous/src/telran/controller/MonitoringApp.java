package telran.controller;

import telran.data.ErrorModule;
import telran.data.GeneralModule;
import telran.data.MonitoringSystem;
import telran.data.SecurityModule;

public class MonitoringApp {
    public static void main(String[] args) {
      /*  GeneralModule general = new GeneralModule();
        ErrorModule error = new ErrorModule();
        SecurityModule security = new SecurityModule();

        general.start();
        error.start();
        security.start();*/
        MonitoringSystem gm = new MonitoringSystem() {
            @Override
            public void start() {
                System.out.println("general module is starting");
            }

            @Override
            public void stop() {
                System.out.println("general module stops");
            }
        };

        MonitoringSystem em = new MonitoringSystem() {
            @Override
            public void start() {
                System.out.println("Error module is starting");
            }

            @Override
            public void stop() {

            }
        };

        MonitoringSystem sm = new MonitoringSystem() {
            @Override
            public void start() {
                System.out.println("Security Module is starting");
            }

            @Override
            public void stop() {

            }
        };
        gm.start();
        em.start();
        sm.start();
        gm.stop();
    }
}
