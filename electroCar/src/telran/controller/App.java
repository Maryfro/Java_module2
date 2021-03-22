package telran.controller;

import telran.data.ElectroCar;

public class App {
    public static void main(String[] args) {
        ElectroCar car = new ElectroCar(230043);
        car.start();
        ElectroCar.Battery battery = new ElectroCar.Battery();
        battery.charge();
        System.out.println(battery.getBatteryStatus());

        System.out.println(car.getReports()[0]);

        ElectroCar.Motor motor = car.new Motor();

        ElectroCar car1 = new ElectroCar(230044) {
            @Override
            public void start() {
                System.out.println("car is moving");
            }
        };
        car1.start();
        System.out.println(car1.getReports()[0]);// method getReports is not implemented at all
    }

}
