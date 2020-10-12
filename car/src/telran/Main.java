package telran;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("BMW", 2000);
        Car.HeadLight light = car.new HeadLight();
        Car.SteeringWheel wheel = car.new SteeringWheel();
        //car.start();
        //light.turnOn();
        Car car1 = new Car("Tesla", 2015);
        car.start();
        wheel.turnLeft();
        wheel.turnRight();
        car.stop();

        car.wheel.turnRight();
        car1.wheel.turnLeft();

    }
}
