package lan.training.jdk8features;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by nik-lazer on 2/4/2016.
 */
public class LambdaForCollectionsTest {
    private List<String> oldFashionSortNames;
    private List<String> longLambdaSortNames;
    private List<String> oneLineSortNames;
    private List<String> shortestSortNames;
    private String[] array;
    @Before
    public void init() {
        array = new String[] {"peter", "anna", "mike", "xenia"};
        List<String> names = Arrays.asList(array);
        oldFashionSortNames = new ArrayList<>(names);
        longLambdaSortNames = new ArrayList<>(names);
        oneLineSortNames = new ArrayList<>(names);
        shortestSortNames = new ArrayList<>(names);
    }

    @Test
    public void sortTest() {

        Collections.sort(oldFashionSortNames, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
        System.out.println("oldFashionSortNames: ");
        for (String name: oldFashionSortNames) {
            System.out.print(name + " ");
        }
        System.out.println();

        Collections.sort(longLambdaSortNames, (String a, String b) -> {
        	return b.compareTo(a);
        });
        System.out.println("longLambdaSortNames: ");
        longLambdaSortNames.forEach((String name) -> {
            System.out.print(name + " ");
        });
        System.out.println();

        Collections.sort(oneLineSortNames, (String a, String b) -> b.compareTo(a)); // Type is not necessary
        System.out.println("oneLineSortNames: ");
        oneLineSortNames.forEach(name -> System.out.print(name + " "));
        System.out.println();

        shortestSortNames.sort((a, b) -> b.compareTo(a));
        System.out.println("shortestSortNames: ");
        shortestSortNames.forEach(System.out::println);

        Arrays.sort(array, (a, b) -> b.compareTo(a));

        assertArrayEquals(oldFashionSortNames.toArray(), longLambdaSortNames.toArray());
        assertArrayEquals(oldFashionSortNames.toArray(), oneLineSortNames.toArray());
        assertArrayEquals(oldFashionSortNames.toArray(), shortestSortNames.toArray());
        assertArrayEquals(oldFashionSortNames.toArray(), array);
    }

}
