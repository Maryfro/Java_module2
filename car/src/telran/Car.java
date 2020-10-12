package telran;

public class Car {
    private String model;
    private int yearOfProduction;
    private HeadLight headLight;
    SteeringWheel wheel;

    public Car(String model, int yearOfProduction) {
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        headLight = new HeadLight();
        wheel = new SteeringWheel();
    }

    public void start() {
        headLight.turnOn();
        System.out.println("go");
    }

    public void stop() {
        System.out.println("stop");
        headLight.turnOff();
    }

    public class SteeringWheel {
        public void turnRight() {
            System.out.println("Turn right");
        }

        public void turnLeft() {
            System.out.println("Turn left");
        }
    }

    public class HeadLight {
        public void turnOn() {
            System.out.println("Light is on");
        }

        public void turnOff() {
            System.out.println("Light is off");
        }
    }
}

