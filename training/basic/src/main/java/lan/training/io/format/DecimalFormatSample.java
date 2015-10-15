package lan.training.io.format;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by nik-lazer on 03.10.15.
 */
public class DecimalFormatSample {
	public static void main(String[] args) {
		double d = 1234567.189;
		DecimalFormat decimalFormat1 = new DecimalFormat("###,###,###.###");
		System.out.println("one: " + decimalFormat1.format(d));

		DecimalFormat decimalFormat2 = new DecimalFormat("000,000,000.00000");
		System.out.println("two: " + decimalFormat2.format(d));

		DecimalFormat decimalFormat3 = new DecimalFormat("$###,###,###.###");
		System.out.println("three: " + decimalFormat3.format(d));

		NumberFormat numberFormat = NumberFormat.getInstance(Locale.GERMAN);
		if (numberFormat instanceof DecimalFormat) {
			DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
			decimalFormat.applyPattern("##,#00.00#");
			double d1 = 21345.684;
			double d2 = 3.4;
			System.out.println(decimalFormat.format(d1));
			System.out.println(decimalFormat.format(d2));
		}
	}
}
