public class Main {
    public static void main(String[] args) {
        CarsComparator cc = new CarsComparator();
        Car oldOpel = new Car(1970, 39000);
        Car newOpel = new Car(2002, 40000);
        Car newMazda = new Car(2002, 20000);
        Car oldMazda = new Car(1990, 20000);
        Car newMazda1 = new Car(2002, 20000);
        if (cc.compare(oldOpel, newOpel) > 0) {
            System.out.println("new opel is better");
        } else if (cc.compare(oldOpel, newOpel) < 0) {
            System.out.println("old opel is better");
        } else {
            System.out.println("equal priority");
        }

        if (cc.compare(newMazda1, newMazda) > 0) {
            System.out.println("new mazda is better");
        } else if (cc.compare(newMazda1, newMazda) < 0) {
            System.out.println("old mazda is better");
        } else {
            System.out.println("equal priority");
        }

        if (cc.compare(oldMazda, newMazda) > 0) {
            System.out.println("new mazda is better");
        } else if (cc.compare(oldMazda, newMazda) < 0) {
            System.out.println("old mazda is better");
        } else {
            System.out.println("equal priority");
        }

    }
}
