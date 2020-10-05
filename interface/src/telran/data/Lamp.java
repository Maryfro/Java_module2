package telran.data;

public class Lamp implements Stateable {


    @Override
    public void printState(int n) {
        if (n == OPEN) {
            System.out.println("light is on");
        } else if (n == CLOSED) {
            System.out.println("light is off");
        } else {
            System.out.println("lamp is defect");
        }
    }
}
