package lan.learn.io;

import java.util.Scanner;

/**
 * Created by nik-lazer on 04.10.15.
 */
public class ScannerSample {
	public static void main(String[] args) {
		String status = "probable,1,questionable;doubtful:out";

		Scanner in = new Scanner(status);
		in.useDelimiter("[,;:]");
		while(in.hasNext()) {
			if (in.hasNextInt()) {
				int num = in.nextInt();
				System.out.println("int="+num);
			} else {
				String token = in.next();
				System.out.println(token);
			}
		}
	}
}
