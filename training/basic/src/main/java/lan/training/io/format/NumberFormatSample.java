package lan.training.io.format;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * Created by nik-lazer on 03.10.15.
 */
public class NumberFormatSample {
	public static void main(String[] args) {
		currencyFormat();
		numberFormat();
		integerFormat();
		percentFormat();

		parseNumbers();
		parseNotFullNumbers();
		parseCurrency();
	}

	private static void parseCurrency() {
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
		try {
			System.out.println(currencyFormat.parse("$123.45"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	private static void parseNumbers() {
		NumberFormat enFormat = NumberFormat.getInstance(Locale.ENGLISH);
		NumberFormat frFormat = NumberFormat.getInstance(Locale.FRANCE);
		String data = "123.45";
		try {
			System.out.println(enFormat.parse(data));
			System.out.println(frFormat.parse(data));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private static void parseNotFullNumbers() {
		NumberFormat format = NumberFormat.getInstance();
		try {
			System.out.println(format.parse("345abc"));
			System.out.println(format.parse("123e10"));
			System.out.println(format.parse("x64"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private static void currencyFormat() {
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
		System.out.println("currency:" + numberFormat.format(59.99321));
	}

	private static void numberFormat() {
		NumberFormat numberFormat = NumberFormat.getNumberInstance();
		System.out.println("number: "+numberFormat.format(59.99321));
	}

	private static void integerFormat() {
		NumberFormat numberFormat = NumberFormat.getIntegerInstance();
		System.out.println("integer: "+numberFormat.format(59.99321));
	}

	private static void percentFormat() {
		NumberFormat numberFormat = NumberFormat.getPercentInstance();
		System.out.println("percent: "+numberFormat.format(0.49321));
	}
}
