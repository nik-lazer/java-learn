/**
 * TODO: comment
 * @author lazarev_nv 20.03.2014   12:37
 */
interface Formula {
	double calculate(int a);

	default double sqrt(int a) {
		return Math.sqrt(a);
	}
}
