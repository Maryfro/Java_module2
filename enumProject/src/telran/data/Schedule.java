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
                System.out.println((i+1) + " sleep longer, yay");
            }
        }
    }

    public void getMenu() {
        for (int i = 0; i < week.length; i++) {
            if (week[i].equals(DaysOfWeek.MONDAY)) {
                System.out.println(DaysOfWeek.MONDAY.getTitle() + " Spaghetti");
            } else if (week[i].equals(DaysOfWeek.TUESDAY)) {
                System.out.println(DaysOfWeek.TUESDAY.getTitle() + " Pizza");
            } else if (week[i].equals(DaysOfWeek.WEDNESDAY)) {
                System.out.println(DaysOfWeek.WEDNESDAY.getTitle() + " Ice-cream");
            } else if (week[i].equals(DaysOfWeek.THURSDAY)) {
                System.out.println(DaysOfWeek.THURSDAY.getTitle() + " Salad");
            } else if (week[i].equals(DaysOfWeek.FRIDAY)) {
                System.out.println(DaysOfWeek.FRIDAY.getTitle() + " Soup");
            } else if (week[i].equals(DaysOfWeek.SATURDAY)) {
                System.out.println(DaysOfWeek.SATURDAY.getTitle() + " Buddha Bowl");
            } else {
                System.out.println(DaysOfWeek.SUNDAY.getTitle() + " Barbecue");
            }
        }
    }
}
