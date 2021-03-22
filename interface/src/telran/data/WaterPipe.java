package telran.data;

public class WaterPipe implements Stateable, Printable {
    @Override
    public void print() {
        System.out.println("I am a pipe");
    }

    @Override
    public void printState(int n) {
        if (n == OPEN) {
            System.out.println("water is open");
        } else if (n == CLOSED) {
            System.out.println("water is close");
        } else {
            System.out.println("status is unclear");
        }
    }
}
