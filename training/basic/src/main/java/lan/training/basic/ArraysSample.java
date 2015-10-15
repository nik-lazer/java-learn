package lan.training.basic;

/**
 * Arrays declaration
 * @author nik-lazer  16.12.2014   11:47
 */
public class ArraysSample {
	int a[];
	int[] a1;
	int[] a2[];
	Object p, p1[], p2[][];

	public static void main(String args[]) {
		int i[]=new int[5];
		int i1[]={1, 3, 5}; // initializator
		String[] arr = new String[]{"firstName", "lastName"};
		testClone();
	}

	public static void testClone() {
		int a[][] = {{1, 2}, {3}};
		int b[][] = (int[][]) a.clone();
		a[0] = new int[]{0};
		System.out.println(b[0][0]);
	}
}
