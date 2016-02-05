package lan.training.jdk8features;

/**
 * @author nik-lazer 25.04.2014   12:36
 */
public class C1 implements I1, I2 {
	@Override
	public void test() {
		System.out.println("C1");
	}

	public void testDouble() {
		System.out.println("C1 double");
	}

}
