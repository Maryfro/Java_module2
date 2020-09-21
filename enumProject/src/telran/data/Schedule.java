package telran.data;


import java.util.Arrays;

public class Schedule {
    private DaysOfWeek[] week;

    public Schedule(DaysOfWeek[] week) {
        this.week = week;
    }


    public DaysOfWeek[] getWeek() {
        return week;
    }

    public void setWeek(DaysOfWeek[] week) {
        this.week = week;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Arrays.equals(week, schedule.week);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(week);
    }

    public void wakeUp() {
        for (int i = 0; i < week.length; i++) {
            if (week[i].ordinal() < 5) {
                System.out.println((i + 1) + " wake up");
            } else {
                System.out.println((i + 1) + " sleep longer, yay");
            }
        }
    }

    public void getMenu(DaysOfWeek day) {
        switch (day) {
            case MONDAY:
                System.out.println(" Spaghetti");
                break;
            case TUESDAY:
                System.out.println(" Pizza");
                break;
            case WEDNESDAY:
                System.out.println(" Ice-cream");
                break;
            case THURSDAY:
                System.out.println(" Salad");
                break;
            case FRIDAY:
                System.out.println(" Buddha Bowl");
                break;
            case SATURDAY:
                System.out.println(" Barbecue");
                break;
            case SUNDAY:
                System.out.println(" Soup");
                break;
        }
    }

    public void displayMenu() {
        for (DaysOfWeek day : week) {
            getMenu(day);
        }
    }
}
