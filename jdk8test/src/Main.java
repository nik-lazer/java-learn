import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

/**
 * большая часть из {@see http://habrahabr.ru/post/216431/}
 * @author lazarev_nv 20.03.2014   11:00
 */
public class Main {
	public static void main(String[] args) {
		//Lambda lambda = new Lambda();
		//lambda.printOld();
		//System.out.println("old");
		//System.out.println(lambda.sumAll());
		//System.out.println(lambda.sumAllEven());

		//System.out.println("new");
		//lambda.printNew();
		//System.out.println(lambda.sumAll(n -> true));
		//System.out.println(lambda.sumAll(n -> n % 2 == 0));
		//System.out.println(lambda.sumAll(n -> n > 3));

		//formulaTest();
		//lambdaTest();
		//predicateTest();
		//sortTest();
		//mapTest();
		//dateTest();
		C1 c1 = new C1();
		c1.test();
		c1.testDouble();
		c1.testThird();
	}

	private static void formulaTest() {
		System.out.println("formulaTest");
		Formula formula = new Formula() {
			@Override
			public double calculate(int a) {
				return sqrt(a * 100);
			}
		};
		System.out.println(formula.calculate(100));     // 100.0
		System.out.println(formula.sqrt(16));
	}

	private static void lambdaTest() {
		System.out.println("lambdaTest");
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return b.compareTo(a);
			}
		});
		names.forEach(System.out::println);
		//Collections.sort(names, (String a, String b) -> {
		//	return b.compareTo(a);
		//});
		//Collections.sort(names, (String a, String b) -> b.compareTo(a));
		Collections.sort(names, (a, b) -> b.compareTo(a));
		names.forEach(value -> System.out.println(value));
	}

	private static void predicateTest() {
		System.out.println("predicateTest");
		Predicate<String> predicate = (s) -> s.length() > 0;

		System.out.println(predicate.test("foo"));              // true
		System.out.println(predicate.negate().test("foo"));     // false

		Predicate<Boolean> nonNull = Objects::nonNull;
		Predicate<Boolean> isNull = Objects::isNull;

		Predicate<String> isEmpty = String::isEmpty;
		Predicate<String> isNotEmpty = isEmpty.negate();
	}

	private static void sortTest() {
		System.out.println("sortTest");
		int max = 1000000;
		List<String> values = new ArrayList<>(max);
		for (int i = 0; i < max; i++) {
			UUID uuid = UUID.randomUUID();
			values.add(uuid.toString());
		}
		List<String> values1 = new ArrayList<>(max);
		for (int i = 0; i < max; i++) {
			UUID uuid = UUID.randomUUID();
			values1.add(uuid.toString());
		}
		sequentialSort(values);
		parallelSort(values1);
	}

	private static void sequentialSort(List<String> values) {
		long t0 = System.nanoTime();

		long count = values.stream().sorted().count();
		System.out.println(count);

		long t1 = System.nanoTime();

		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println(String.format("sequential sort took: %d ms", millis));
		// sequential sort took: 899 ms
	}

	private static void parallelSort(List<String> values) {
		long t0 = System.nanoTime();

		long count = values.parallelStream().sorted().count();
		System.out.println(count);

		long t1 = System.nanoTime();

		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println(String.format("parallel sort took: %d ms", millis));

		// parallel sort took: 472 ms
	}

	private static void mapTest() {
		System.out.println("mapTest");
		Map<Integer, String> map = new HashMap<>();

		for (int i = 0; i < 10; i++) {
			map.putIfAbsent(i, "val" + i);
		}

		map.forEach((id, val) -> System.out.println(val));

		map.computeIfPresent(3, (num, val) -> val + num);
		System.out.println(map.get(3));             // val33

		map.computeIfPresent(9, (num, val) -> null);
		System.out.println(map.containsKey(9));     // false

		map.computeIfAbsent(23, num -> "val" + num);
		System.out.println(map.containsKey(23));    // true

		map.computeIfAbsent(3, num -> "bam");
		System.out.println(map.get(3));             // val33

		map.remove(3, "val3");
		System.out.println(map.get(3));             // val33

		map.remove(3, "val33");
		System.out.println(map.get(3));             // null

		System.out.println(map.getOrDefault(42, "not found"));  // not found

		map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
		System.out.println(map.get(9));             // val9

		map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
		System.out.println(map.get(9));             // val9concat
	}

	private static void dateTest() {
		System.out.println("dateTest");
		Clock clock = Clock.systemDefaultZone();
		long millis = clock.millis();

		Instant instant = clock.instant();
		Date legacyDate = Date.from(instant);   // legacy java.util.Date

		System.out.println(ZoneId.getAvailableZoneIds());
		// prints all available timezone ids

		ZoneId zone1 = ZoneId.of("Europe/Berlin");
		ZoneId zone2 = ZoneId.of("Brazil/East");
		System.out.println(zone1.getRules());
		System.out.println(zone2.getRules());

		// ZoneRules[currentStandardOffset=+01:00]
		// ZoneRules[currentStandardOffset=-03:00]

		LocalTime now1 = LocalTime.now(zone1);
		LocalTime now2 = LocalTime.now(zone2);

		System.out.println(now1.isBefore(now2));  // false

		long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
		long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);

		System.out.println(hoursBetween);       // -3
		System.out.println(minutesBetween);     // -239

		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
		LocalDate yesterday = tomorrow.minusDays(2);

		LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 4);
		DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
		System.out.println(dayOfWeek);    // FRIDAY

		DateTimeFormatter germanFormatter =
				DateTimeFormatter
						.ofLocalizedDate(FormatStyle.MEDIUM)
						.withLocale(Locale.GERMAN);

		LocalDate xmas = LocalDate.parse("24.12.2014", germanFormatter);
		System.out.println(xmas);   // 2014-12-24

		LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);

		dayOfWeek = sylvester.getDayOfWeek();
		System.out.println(dayOfWeek);      // WEDNESDAY

		Month month = sylvester.getMonth();
		System.out.println(month);          // DECEMBER

		long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
		System.out.println(minuteOfDay);    // 1439

		instant = sylvester
				.atZone(ZoneId.systemDefault())
				.toInstant();

		legacyDate = Date.from(instant);
		System.out.println(legacyDate);     // Wed Dec 31 23:59:59 CET 2014

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy - HH:mm");

		LocalDateTime parsed = LocalDateTime.parse("Nov 03, 2014 - 07:13", formatter);
		String string = formatter.format(parsed);
		System.out.println(string);     // Nov 03, 2014 - 07:13
	}
}
