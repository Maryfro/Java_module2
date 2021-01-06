import java.util.Comparator;

public class CarsComparator implements Comparator<Car> {


    @Override
    public int compare(Car o1, Car o2) {
        if (o1.getMileage() == o2.getMileage()) {
            return -(o1.getYearOfIssue() - o2.getYearOfIssue());
        }
        return o1.getMileage() - o2.getMileage();
    }
}

