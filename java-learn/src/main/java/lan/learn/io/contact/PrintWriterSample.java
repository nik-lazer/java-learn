package lan.learn.io.contact;

import java.io.Console;
import java.io.PrintWriter;
import java.util.Formatter;

/**
 * Created by nik-lazer on 01.10.15.
 */
public class PrintWriterSample {
	public static void main(String[] args) {
		int i = 101;
		double d = 1.0/3.0;
		String s = "hello";
		boolean b = true;
		char c = 'a';
		PrintWriter pw = new PrintWriter(System.out, true);
		pw.println(i);
		pw.println(d);
		pw.println(s);
		pw.println(b);

		String prefix = "d = ";
		pw.printf("%s%7.3f%n", prefix, d);
		pw.format("c=%c%n", c);
		pw.format("b=%b%n", b);
		pw.format("i=%d%n", i);

		StringBuilder sb = new StringBuilder();
		Formatter formatter = new Formatter(sb);
		formatter.format("df=%5.3f, if=%6d%n", d, i);
		System.out.println(sb.toString());

		Console console = System.console();
		if (console == null) {
			System.out.println("Console is not avaliable");
		} else {
			console.format("dc=%8.3f, ic=%9d%n", d, i);
		}
	}
}
