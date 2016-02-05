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
    DateTimeFormatter formatter;
    @Before
    public void init() {
        formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy - HH:mm");
    }
    @Test
    public void formatTest() {
        LocalDateTime localDateTime = LocalDateTime.of(2014, 11, 3, 7, 13, 23);
        String string = formatter.format(localDateTime);
        assertEquals("Nov 03, 2014 - 07:13", string);
    }

    @Test
    public void parseTest() {
        LocalDateTime parsed = LocalDateTime.parse("Nov 03, 2014 - 07:13", formatter);
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
