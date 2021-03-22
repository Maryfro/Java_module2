public class Car {
    private int yearOfIssue;
    private int mileage;

    public Car(int yearOfIssue, int mileage) {
        this.yearOfIssue = yearOfIssue;
        this.mileage = mileage;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public int getMileage() {
        return mileage;
    }

    @Override
    public String toString() {
        return "Car: " +
                "yearOfIssue=" + yearOfIssue +
                ", mileage=" + mileage;
    }
}
