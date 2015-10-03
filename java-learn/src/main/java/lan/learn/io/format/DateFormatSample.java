package lan.learn.io.format;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by nik-lazer on 03.10.15.
 */
public class DateFormatSample {
	public static void main(String[] args) {
		parse();
		format();
	}

	private static void format() {
		DateFormat fullDateFormat = DateFormat.getDateInstance(DateFormat.FULL);
		System.out.println("full: " + fullDateFormat.format(new Date()));
		DateFormat shortDateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		System.out.println("short: " + shortDateFormat.format(new Date()));
		DateFormat mediumDateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
		System.out.println("medium: " + mediumDateFormat.format(new Date()));
		DateFormat defaultDateFormat = DateFormat.getDateInstance();
		System.out.println("default: " + mediumDateFormat.format(new Date()));
	}

	private static void parse() {
		DateFormat dateFormat = DateFormat.getDateInstance();
		String date = "15.03.2015";
		try {
			System.out.println("15.03.2015=" + dateFormat.parse(date));
			System.out.println("15.03.2015a=" + dateFormat.parse("15.03.2015a"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
