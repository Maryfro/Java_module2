package telran.application;

import telran.data.DaysOfWeek;
import telran.data.Schedule;


public class App {
    public static void main(String[] args) {
        //DaysOfWeek monday = DaysOfWeek.MONDAY;
     /*   System.out.println(monday.toString().toLowerCase());
        System.out.println(DaysOfWeek.FRIDAY.ordinal());
        System.out.println(Arrays.toString(DaysOfWeek.values()));
        System.out.println(DaysOfWeek.WEDNESDAY.getTitle());*/
      //  DaysOfWeek.THURSDAY.sayHello();
       // monday.sayHello();
        DaysOfWeek[] week = {DaysOfWeek.MONDAY, DaysOfWeek.TUESDAY, DaysOfWeek.WEDNESDAY, DaysOfWeek.THURSDAY,
                DaysOfWeek.FRIDAY, DaysOfWeek.SATURDAY, DaysOfWeek.SUNDAY};
        Schedule schedule1 = new Schedule(week);
        System.out.println("Schedule for one week ");
        schedule1.wakeUp();
        System.out.println("--------------------");
        System.out.println("Menu of the week ");
        schedule1.displayMenu();
    }
}
