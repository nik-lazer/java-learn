package lan.training.jdk8features.time;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

/**
 * Created by nik-lazer on 2/5/2016.
 */
public class FormatTest {
    DateTimeFormatter dateTimeFormatter;
    DateTimeFormatter dateFormatter;
    @Before
    public void init() {
        dateTimeFormatter = DateTimeFormatter.ofPattern("MMM dd, yyyy - HH:mm");
        dateFormatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
    }
    @Test
    public void formatTest() {
        LocalDateTime localDateTime = LocalDateTime.of(2014, 11, 3, 7, 13, 23);
        LocalDate localDate = LocalDate.of(2014, 12, 5);
        String formattedDateTime = dateTimeFormatter.format(localDateTime);
        String formattedDate = dateFormatter.format(localDate);
        assertEquals("Nov 03, 2014 - 07:13", formattedDateTime);
        assertEquals("Dec 05, 2014", formattedDate);
    }

    @Test
    public void parseTest() {
        LocalDateTime parsed = LocalDateTime.parse("Nov 03, 2014 - 07:13", dateTimeFormatter);
        assertEquals(3, parsed.getDayOfMonth());
        assertEquals(2014, parsed.getYear());
        assertEquals(Month.NOVEMBER, parsed.getMonth());
        assertEquals(7, parsed.getHour());
        assertEquals(13, parsed.getMinute());
        assertEquals(0, parsed.getSecond());
    }

    @Test
    public void germanFormatterTest() {
        DateTimeFormatter germanFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
                        .withLocale(Locale.GERMAN);

        LocalDate xmas = LocalDate.parse("24.12.2014", germanFormatter);
        assertEquals("2014-12-24", xmas.toString());
    }
}
