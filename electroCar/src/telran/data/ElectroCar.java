package telran.data;

public class ElectroCar {
    private int idNumber;
    private Motor motor = new Motor();
    private Battery battery = new Battery();
    private String[] reports;
    private int reportsNumber = 0;

    public ElectroCar(int idNumber) {
        this.idNumber = idNumber;
        reports = new String[100];
    }

    public String[] getReports() {
        return reports;
    }

    public class Motor {
        private void start() {
            System.out.println("Motor of car " + idNumber + " is starting");
        }

        public String getMotorStatus() {
            return "motor is ok";
        }
    }

    public static class Battery {
        public void charge() {
            System.out.println("Battery is charging");
        }

        public String getBatteryStatus() {
            return "battery is charged";
        }
    }

    public void start() {
        motor.start();

        class CheckReport {
            private String motorCheck;
            private String batteryCheck;

            CheckReport() {
                motorCheck = motor.getMotorStatus();
                batteryCheck = battery.getBatteryStatus();
            }

            private void writeReport() {
                System.out.println(motorCheck + ", " + batteryCheck);
            }
        }
        CheckReport checkReport = new CheckReport();
        checkReport.writeReport();
        System.out.println("car " + idNumber + " stars going");
        reports[reportsNumber] = checkReport.motorCheck + ", " + checkReport.batteryCheck;
        reportsNumber++;

    }
}
