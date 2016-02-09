package lan.training.jdk8features.stream;

/**
 * Created by nik-lazer on 2/9/2016.
 */
public class ExceptionSample {
    public static double getLog10(int number) throws CheckedException {
        if (number <0) {
            throw new CheckedException("digit must be above 0");
        }
        return Math.log10(number);
    }
}
