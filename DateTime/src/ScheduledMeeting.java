import java.time.*;

public class ScheduledMeeting {


    public int intersectWorkingTime(LocalTime start1, int hours1, ZoneId zone1, LocalTime start2, int hours2, ZoneId zone2) {
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
    }

    public static void main(String[] args) {
        System.out.println(ZoneId.getAvailableZoneIds());

    }
}
