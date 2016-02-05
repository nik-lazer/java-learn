package lan.training.jdk7features;

import java.util.Arrays;
import java.util.List;

/**
 * Created by nik-lazer on 2/4/2016.
 */
public class VarargsWarnings {
    public static void main(String[] args) {
        List<List<String>> monthsInSeasons = Arrays.asList(
                Arrays.asList("December", "January", "February"),
                Arrays.asList("March", "April", "May")
        );
        System.out.println(monthsInSeasons);
    }
}
