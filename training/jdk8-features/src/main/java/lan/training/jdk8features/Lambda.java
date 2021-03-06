package lan.training.jdk8features;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * {@see http://habrahabr.ru/post/213805/}
 * @author nik-lazer 20.03.2014   11:02
 */
public class Lambda {
	private List<Integer> numbers;

	public Lambda(Integer... number) {
		numbers = Arrays.asList(number);
	}

	public void printOld() {
		for (int number : numbers) {
			System.out.println(number);
		}
	}

	public void printNew() {
		//numbers.forEach((Integer value) -> System.out.println(value));
		//numbers.forEach(value -> System.out.println(value));
		numbers.forEach(System.out::println);
	}

	public int sumAll() {
		int total = 0;
		for (int number : numbers) {
			total += number;
		}
		return total;
	}

	public int sumAllEven() {
		int total = 0;
		for (int number : numbers) {
			if (number % 2 == 0) {
				total += number;
			}
		}
		return total;
	}

	public int sumAll(Predicate<Integer> p) {
		int total = 0;
		for (int number : numbers) {
			if (p.test(number)) {
				total += number;
			}
		}
		return total;
	}
}
