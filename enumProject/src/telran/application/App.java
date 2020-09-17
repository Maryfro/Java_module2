package telran.application;

import telran.data.DaysOfWeek;
import telran.data.Schedule;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        DaysOfWeek monday = DaysOfWeek.MONDAY;
        System.out.println(monday.toString().toLowerCase());
        System.out.println(DaysOfWeek.FRIDAY.ordinal());
        System.out.println(Arrays.toString(DaysOfWeek.values()));
        System.out.println(DaysOfWeek.WEDNESDAY.getTitle());
        DaysOfWeek.THURSDAY.sayHello();
        monday.sayHello();
        Schedule schedule1 = new Schedule(DaysOfWeek.MONDAY);
        schedule1.wakeUp();
        Schedule schedule2 = new Schedule(DaysOfWeek.SATURDAY);
        schedule2.wakeUp();
        System.out.println("--------------------");
        Schedule[] schedules = {schedule1, new Schedule(DaysOfWeek.TUESDAY), new Schedule(DaysOfWeek.WEDNESDAY),
                new Schedule(DaysOfWeek.THURSDAY), new Schedule(DaysOfWeek.FRIDAY), schedule2,
                new Schedule(DaysOfWeek.SUNDAY)};
        System.out.println( "Menu of the week: ");
        for (Schedule s:schedules) {
            s.getMenu();
        }
    }
}
