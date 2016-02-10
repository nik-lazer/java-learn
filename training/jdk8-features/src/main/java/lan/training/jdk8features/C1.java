package lan.training.jdk8features;

/**
 * @author nik-lazer 25.04.2014   12:36
 */
public class C1 implements I1, I2 {
	@Override
	public String test() {
		return "C1";
	}

	public String testDouble() {
		return I1.super.testDouble() + "C1 double";
	}

}
