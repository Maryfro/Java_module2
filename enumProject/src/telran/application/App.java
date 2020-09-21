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
        Schedule schedule1 = new Schedule();
        System.out.print("On " + DaysOfWeek.FRIDAY.getTitle() + " you have to");
        schedule1.wakeUp(DaysOfWeek.FRIDAY);
        System.out.print("On " + DaysOfWeek.SUNDAY.getTitle() + " you can");
        schedule1.wakeUp(DaysOfWeek.SUNDAY);
        System.out.println("--------------------");
        System.out.println("Menu of the week ");
        schedule1.displayMenu();
    }
}
