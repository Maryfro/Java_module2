package telran.data;

public class Schedule {
    private DaysOfWeek dayOfWeek;
    private DaysOfWeek[] week;

    public Schedule(DaysOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
       // this.week = DaysOfWeek.values();
    }

    public DaysOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DaysOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
    public void wakeUp(){
        if (getDayOfWeek() == DaysOfWeek.SATURDAY || getDayOfWeek() == DaysOfWeek.SUNDAY){
            System.out.println("sleep longer, yay");
        }else {
            System.out.println("wake up");
        }
       // if(dayOfWeek.ordinal()>= 5)
    }

    public void getMenu(){
        switch(dayOfWeek){
            case MONDAY:
                System.out.println("Spaghetti");
                break;
            case TUESDAY:
                System.out.println("Pizza");
                break;
            case WEDNESDAY:
                System.out.println("Ice-cream");
                break;
            case THURSDAY:
                System.out.println("Salad");
                break;
            case FRIDAY:
                System.out.println("Soup");
                break;
            case SATURDAY:
                System.out.println("Buddha Bowl");
                break;
            case SUNDAY:
                System.out.println("Barbecue");
                break;

        }
    }
}
