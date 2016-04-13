package lan.training.mock;

/**
 * Some business logic with calculations inside
 * Created by nik-lazer on 4/8/2016.
 */
public class LegacyClass {
    private static String[] arr = {"s1", "string2", "sss3"};
    public static void work() {
        for (int i = 0; i<arr.length;i++) {
            calculate(arr[i], i);
        }
    }

    public static void calculate(String s, int i) {
        new Calculation().calculate(s, i);
    }
}
