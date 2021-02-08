import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Main {
    //TODO Vasya, Petya, Tanya work in a bank
//Tanya is smart and stable employee, issues a loan in time of
//100 to 200 millis
//Petya is stable, but not so smart.He issues every loan in time of 200-300 millis
//Vasya is smart, but lazy. He issues every loan in time of 200-300 millis, but
//if Vasya has enlightenment, he issues next three loans in time of 50-100millis each.
//The probability of his enlightenment is 20%.  if(random.next(100)<20)
//every employee issues 20 loans. Who will be ready first?

    public static void main(String[] args) throws InterruptedException {
        long startingTime = System.currentTimeMillis();
        Employee Tanya = new Employee("Tanya", 100, 200, 20, startingTime, true);
        Employee Petya = new Employee("Petya", 200, 300, 20, startingTime, true);
        Employee Vasya = new Employee("Vasya", 200, 300, 20, startingTime, false);
        List<Employee> employees = new ArrayList<>();
        employees.add(Tanya);
        employees.add(Petya);
        employees.add(Vasya);
        Thread TanyaThread = new Thread(Tanya);
        Thread PetyaThread = new Thread(Petya);
        Thread VasyaThread = new Thread(Vasya);
        TanyaThread.start();
        PetyaThread.start();
        VasyaThread.start();
        TanyaThread.join();
        PetyaThread.join();
        VasyaThread.join();
        System.out.println("Tanya " + Tanya.resTime);
        System.out.println("Petya " + Petya.resTime);
        System.out.println("Vasya " + Vasya.resTime);
        System.out.println("the quickest employee is " + findTheQuickestEmployee(employees));
    }

    public static Employee findTheQuickestEmployee(List<Employee> employees) {
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int) (o1.resTime - o2.resTime);
            }
        });
        return employees.get(0);
    }
}
