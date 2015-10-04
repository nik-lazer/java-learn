package lan.learn.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nik-lazer on 03.10.15.
 */
public class RegexpSample {
	public static void main(String[] args) {
		matcherFind();
		splitByRegexp();
	}

	public static void matcherFind() {
		String patternString = ".ing";
		String data = "ing ring trying running beings";
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(data);
		int i = 0;
		while (matcher.find(i)) {
			System.out.println("Finded: " + matcher.group() + "[" + matcher.start() + ", " + matcher.end() + "]");
			i = matcher.end() + 1;
		}
	}

	public static void splitByRegexp() {
		String data = "3035551212,123 Main St.\tDenver,CO:50431";
		String [] results = data.split("[;,:\\t]");
		for(String result : results) {
			System.out.println(result);
		}
	}
}