import java.time.*;
import java.time.temporal.ChronoUnit;

public class ScheduledMeeting {


    public int intersectWorkingTime(LocalTime start1, int hours1, ZoneId zone1, LocalTime start2, int hours2, ZoneId zone2) {
        int resToday = intersectWorkingTimeToday(start1, hours1, zone1, start2, hours2, zone2);
        int resYesterday = intersectWorkingTimeYesterday(start1, hours1, zone1, start2, hours2, zone2);
        int resTomorrow = intersectWorkingTimeTomorrow(start1, hours1, zone1, start2, hours2, zone2);
        if (resToday > 0)
            return resToday;
        if (resTomorrow > 0)
            return resTomorrow;
        else
            return resYesterday;
    }

    private int intersectWorkingTimeToday(LocalTime start1, int hours1, ZoneId zone1, LocalTime start2, int hours2, ZoneId zone2) {
        ZonedDateTime office1Start = ZonedDateTime.of(LocalDate.now(), start1, zone1);
        ZonedDateTime office2Start = ZonedDateTime.of(LocalDate.now(), start2, zone2);
        ZonedDateTime office1End = office1Start.plusHours(hours1);
        ZonedDateTime office2End = office2Start.plusHours(hours2);

        ZonedDateTime intersectionStart = office1Start.isBefore(office2Start) ? office2Start : office1Start;
        ZonedDateTime intersectionEnd = office1End.isAfter(office2End) ? office2End : office1End;
        int result = (int) intersectionStart.until(intersectionEnd, ChronoUnit.HOURS);
        return Math.max(result, 0);
    }

    private int intersectWorkingTimeTomorrow(LocalTime start1, int hours1, ZoneId zone1, LocalTime start2, int hours2, ZoneId zone2) {
        ZonedDateTime office1Start = ZonedDateTime.of(LocalDate.now().plusDays(1), start1, zone1);
        ZonedDateTime office2Start = ZonedDateTime.of(LocalDate.now(), start2, zone2);
        ZonedDateTime office1End = office1Start.plusHours(hours1);
        ZonedDateTime office2End = office2Start.plusHours(hours2);

        ZonedDateTime intersectionStart = office1Start.isBefore(office2Start) ? office2Start : office1Start;
        ZonedDateTime intersectionEnd = office1End.isAfter(office2End) ? office2End : office1End;
        int result = (int) intersectionStart.until(intersectionEnd, ChronoUnit.HOURS);
        return Math.max(result, 0);
    }

    private int intersectWorkingTimeYesterday(LocalTime start1, int hours1, ZoneId zone1, LocalTime start2, int hours2, ZoneId zone2) {
        ZonedDateTime office1Start = ZonedDateTime.of(LocalDate.now().minusDays(1), start1, zone1);
        ZonedDateTime office2Start = ZonedDateTime.of(LocalDate.now(), start2, zone2);
        ZonedDateTime office1End = office1Start.plusHours(hours1);
        ZonedDateTime office2End = office2Start.plusHours(hours2);

        ZonedDateTime intersectionStart = office1Start.isBefore(office2Start) ? office2Start : office1Start;
        ZonedDateTime intersectionEnd = office1End.isAfter(office2End) ? office2End : office1End;
        int result = (int) intersectionStart.until(intersectionEnd, ChronoUnit.HOURS);
        return Math.max(result, 0);
    }


    public static void main(String[] args) {
        System.out.println(ZoneId.getAvailableZoneIds());
    }

    /*
     * ******this method works for office hours not on the edge of the days*******
     */
    /* public int intersectWorkingTime(LocalTime start1, int hours1, ZoneId zone1, LocalTime start2, int hours2, ZoneId zone2) {
        ZonedDateTime office1Start = ZonedDateTime.of(LocalDate.now(), start1, zone1);
        ZonedDateTime office2Start = ZonedDateTime.of(LocalDate.now(), start2, zone2);
        LocalTime end1 = start1.plusHours(hours1);
        LocalTime end2 = start2.plusHours(hours2);
        ZonedDateTime office1End = ZonedDateTime.of(LocalDate.now(), end1, zone1);
        ZonedDateTime office2End = ZonedDateTime.of(LocalDate.now(), end2, zone2);
        int localHourOfOffice2ByOffice1Start = office1Start.withZoneSameInstant(office2Start.getZone()).getHour();
        int localHourOfOffice2ByOffice1End = office1End.withZoneSameInstant(office2End.getZone()).getHour();
        int intersectionStart = Math.max(start1.getHour(), localHourOfOffice2ByOffice1Start);
        int intersectionEnd = Math.min(end1.getHour(), localHourOfOffice2ByOffice1End);
        if (localHourOfOffice2ByOffice1Start > end1.getHour())
            return 0;
        return intersectionEnd - intersectionStart;
    }
*/




    /*
    public int intersectWorkingTime2(LocalTime start1, int hours1, ZoneId zone1, LocalTime start2, int hours2, ZoneId zone2) {
        LocalTime end1 = start1.plusHours(hours1);
        int end1Hour = end1.getHour();
        LocalTime end2 = start2.plusHours(hours2);
        int utc1 = parseTimeZone(zone1);
        int utc2 = parseTimeZone(zone2);
        int utcDifference = utc1 - utc2;
        int zoneSameInstantStart = start2.getHour() + utcDifference;
        int zoneSameInstantEnd = end2.getHour() + utcDifference;
        if (zoneSameInstantStart >= start1.getHour() && zoneSameInstantStart < end1Hour) {
            return end1Hour - zoneSameInstantStart;
        } else if (zoneSameInstantEnd > start1.getHour() && zoneSameInstantEnd <= end1Hour) {
            return zoneSameInstantEnd - start1.getHour();
        } else if (zoneSameInstantStart == start1.getHour() && zoneSameInstantEnd == end1Hour) {
            return hours1;
        } else
            return 0;
    }

    private int parseTimeZone(ZoneId zone) {
        String utc = zone.getRules().toString();
        String[] parseZone1 = utc.split("=");
        String res = parseZone1[1].split(":")[0];
        if (res.equals("Z]"))
            res = "00";
        return Integer.parseInt(res);
    }*/
}
