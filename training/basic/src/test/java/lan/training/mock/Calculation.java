package lan.training.mock;

/**
 * Encapsulates complex calculations
 * Created by nik-lazer on 4/11/2016.
 */
public class Calculation {
    public boolean calculate(String s, int i) {
        System.out.println("calculate: "+s + "::" +i);
        return true;
    }

    public Calculation() {
        System.out.println("calculation");
    }
}
