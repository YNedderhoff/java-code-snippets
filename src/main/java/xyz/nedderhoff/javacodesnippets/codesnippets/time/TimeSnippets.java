package xyz.nedderhoff.javacodesnippets.codesnippets.time;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeSnippets {
    public static void main(String[] args) {
        Timestamp timestamp = Timestamp.from(Instant.now());

        System.out.println(timestamp.toString());
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(timestamp.toInstant(), ZoneId.of("+0"));
        System.out.println(zonedDateTime.toString());

        DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME.withZone(ZoneId.of("+0"));
        OffsetDateTime offsetDateTime1 = OffsetDateTime.ofInstant(timestamp.toInstant(), ZoneId.of("+0"));
        OffsetDateTime offsetDateTime2 = OffsetDateTime.ofInstant(Instant.ofEpochMilli(timestamp.getTime()), ZoneId.of("+0"));
        System.out.println(formatter.format(offsetDateTime1));
        System.out.println(formatter.format(offsetDateTime2));

        String input = "2016-04-22T17:45:00+02:00";
        OffsetDateTime odt = OffsetDateTime.parse(input);
        System.out.println(odt.toString());

        String unparsedDateString = "2020-05-22T22:00:00.000Z";
        DateTimeFormatter timezoneFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        Instant parseDateInstant = Instant.parse(unparsedDateString);
        String parsedDateString = timezoneFormatter.withZone(ZoneId.of("+5")).format(parseDateInstant);
        System.out.println(unparsedDateString);
        System.out.println(parsedDateString);
    }
}
