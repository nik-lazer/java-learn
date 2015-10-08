package lan.learn.basic;

/**
 * Access to field of static inner class
 * @author nik-lazer  08.10.2015   16:06
 */
class Outer {
	static class Inner {
		public final String text = "Inner";
	}
}

public class InnerClassAccess {
	public static void main(String []args) {
		System.out.println(new Outer.Inner().text);
	}
}