package lan.training.date;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;

/**
 * Sample for {@link java.util.Calendar}
 * @author nik-lazer  13.10.2015   13:56
 */
public class CalendarTest {
	@Test
	public void setTest() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 1996);
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
		calendar.set(Calendar.DAY_OF_MONTH, 23);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
		String formattedDate = simpleDateFormat.format(calendar.getTime());
		assertEquals("23.01.1996", formattedDate);
	}
}
