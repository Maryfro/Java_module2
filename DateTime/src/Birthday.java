import java.time.LocalDate;
import java.time.Period;

public class Birthday {
    public static void main(String[] args) {
        LocalDate myBirthday = LocalDate.of(1990, 4, 26);
        System.out.println(myBirthday.getDayOfWeek());
        System.out.println(myBirthday.getDayOfYear());
        LocalDate myBirthday2021 = LocalDate.of(2021, 4, 26);
        LocalDate today = LocalDate.now();
        System.out.println(today.isBefore(myBirthday2021)); //exp. true
        //int difference = myBirthday2021.getDayOfYear() - today.getDayOfYear();
        //System.out.println(difference);
        LocalDate diff = myBirthday2021.minusDays(today.getDayOfYear());
        System.out.println(diff.getDayOfYear());
    }
}
