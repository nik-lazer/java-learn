package lan.training.jdk8features;

/**
 * TODO: comment
 * @author nik-lazer 20.03.2014   12:37
 */
interface Formula {
	double calculate(int a);

	default double sqrt(int a) {
		return Math.sqrt(a);
	}
}