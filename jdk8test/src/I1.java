/**
 * TODO: comment
 * @author lazarev_nv 25.04.2014   12:34
 */
public interface I1 {
	void test();
	default void testDouble() {
		System.out.println("I1");
	}
}
