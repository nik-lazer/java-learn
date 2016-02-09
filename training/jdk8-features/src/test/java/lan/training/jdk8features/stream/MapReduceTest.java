package lan.training.jdk8features.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Created by nik-lazer on 2/8/2016.
 */
public class MapReduceTest {
    private List<Person> persons = new ArrayList<>();

    @Before
    public void init() {
        persons.addAll(Arrays.asList(
                new Person("John", "Smith", 34),
                new Person("John", "Doe", 45),
                new Person("John", "Smith", 23),
                new Person("Jane", "Doe", 33)
        ));
    }

    @Test
    public void mapTest() {
        String ret = persons.stream()
                .map(person -> person.getLastName() + " " + person.getFirstName())
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));
        assertEquals("Doe Jane, Doe John, Smith John", ret);
    }

    @Test
    public void flatMapTest() {
        String ret = persons.stream()
                .flatMap(person -> Arrays.asList(person.getLastName(), person.getFirstName()).stream())
                .distinct()
                .collect(Collectors.joining(", "));
        assertEquals("Smith, John, Doe, Jane", ret);
    }

    @Test
    public void reduceTest() {
        Person oldest = persons.stream()
                .reduce((person, person2) -> (person.getAge() > person2.getAge() ? person : person2))
                .get();
        assertEquals(45, oldest.getAge());
        assertEquals("John", oldest.getFirstName());
        assertEquals("Doe", oldest.getLastName());
    }

}
