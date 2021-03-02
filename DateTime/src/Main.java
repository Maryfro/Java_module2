import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        //LocalDate

        LocalDate now = LocalDate.now();
        System.out.println(now);
        LocalDate tomorrow = now.plus(Period.ofDays(1));
        System.out.println(tomorrow);
        tomorrow = now.plusDays(1);
        System.out.println(tomorrow);
        tomorrow = now.plus(1, ChronoUnit.DAYS);
        System.out.println(tomorrow);

        System.out.println("Today is " + now.getDayOfWeek());
        System.out.println(now.isAfter(tomorrow));//false
        System.out.println(now.toEpochSecond(LocalTime.now(), ZoneOffset.UTC));
        System.out.println(System.currentTimeMillis());
        System.out.println(ZoneId.getAvailableZoneIds());

        //LocalTime
        LocalTime currentTime = LocalTime.now();
        LocalTime nextHour = currentTime.plus(Duration.ofHours(1));
        System.out.println(nextHour);
        nextHour = currentTime.plus(1, ChronoUnit.HOURS);
        System.out.println(nextHour);
        nextHour = currentTime.plusHours(1);
        System.out.println(currentTime.isBefore(nextHour));//true


        //LocalDateTime
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime parsed = LocalDateTime.parse("2021-03-02T12:27:53");
        System.out.println(today);
        System.out.println(parsed);
        System.out.println(parsed.get(ChronoField.DAY_OF_YEAR)); //Chrono field
        LocalDateTime fromDateAndTime = LocalDateTime.of(now, currentTime);
        //with()
        LocalDateTime yearAgo = today.withYear(2020);
        System.out.println(yearAgo);

        //ZonedDateTime
        ZonedDateTime minskMorning = ZonedDateTime
                .of(LocalDateTime.of(2021, Month.MARCH, 3, 6, 0),
                        ZoneId.of("Europe/Minsk"));
        System.out.println(minskMorning);
        ZonedDateTime vladivostokMorning = minskMorning.withZoneSameInstant(ZoneId
                .of("Asia/Vladivostok")); //how to find time in another zone
        System.out.println(vladivostokMorning);
        ZonedDateTime sameTimeOtherzone = minskMorning
                .withZoneSameLocal(ZoneId.of("Asia/Vladivostok"));
        System.out.println(sameTimeOtherzone);

        //Differences between times/dates etc
        Period period = Period.between(now, tomorrow);

        //for time
        Duration duration = Duration.between(currentTime, nextHour);
        System.out.println(duration); //period time 1 hour
        System.out.println(duration.getSeconds());
        System.out.println(ChronoUnit.MINUTES.between(nextHour, currentTime));


        //Formatting
        LocalDateTime fromStandardString = LocalDateTime.parse("2021-03-02T12:27:53");
        Locale l = Locale.JAPAN;
        System.out.println(l);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate fromPattern = LocalDate.parse("2021/03/02", formatter);
        System.out.println(fromPattern.toString());
        System.out.println(fromPattern.format(formatter));
    }
}
