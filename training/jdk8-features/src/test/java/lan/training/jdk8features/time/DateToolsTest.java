package lan.training.jdk8features.time;

import org.junit.Before;
import org.junit.Test;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by nik-lazer on 2/5/2016.
 */
public class DateToolsTest {
    ZoneId zone1;
    ZoneId zone2;
    @Before
    public void init() {
        zone1 = ZoneId.of("Europe/Berlin");
        zone2 = ZoneId.of("Brazil/East");
        System.out.println(zone1.getRules());
        System.out.println(zone2.getRules());
    }

    @Test
    public void instantTest() {
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();

        Instant instant = clock.instant();
        Date legacyDate = Date.from(instant);   // legacy java.util.Date
        Date oldDate = new Date(millis);

        assertEquals(oldDate, legacyDate);
    }

    @Test
    public void localTimeTest() {
        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);

        assertFalse(now1.isBefore(now2));

        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);

        assertFalse(hoursBetween > 0);
        assertFalse(minutesBetween > 0);
    }

    @Test
    public void localDateTest() {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        LocalDate yesterday = tomorrow.minusDays(2);
        assertTrue(tomorrow.isAfter(today));
        assertTrue(yesterday.isBefore(today));

        LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 4);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
        assertEquals(DayOfWeek.FRIDAY, dayOfWeek);

    }

    @Test
    public void localDateTimeTest() {
        LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);

        DayOfWeek dayOfWeek = sylvester.getDayOfWeek();
        assertEquals(DayOfWeek.WEDNESDAY, dayOfWeek);

        Month month = sylvester.getMonth();
        assertEquals(Month.DECEMBER, month);

        long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
        assertEquals(1439, minuteOfDay);

        Instant instant = sylvester
                .atZone(ZoneId.systemDefault())
                .toInstant();

        Date legacyDate = Date.from(instant);
        System.out.println(legacyDate);     // Wed Dec 31 23:59:59 CET 2014

    }
}
