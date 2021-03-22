import java.time.LocalDate;

public class NewYearCountdown {

    public int countDaysTillNewYear(LocalDate now, LocalDate newYear) {
        LocalDate res = newYear.minusDays(now.getDayOfYear());
        return res.getDayOfYear();
        // return newYear.getDayOfYear() - now.getDayOfYear();
    }

    public static void main(String[] args) {
        NewYearCountdown countdown = new NewYearCountdown();
        LocalDate now = LocalDate.now();
        LocalDate newYear = LocalDate.MAX;
        System.out.println(newYear);
        System.out.println(countdown.countDaysTillNewYear(now, newYear));
    }
}
