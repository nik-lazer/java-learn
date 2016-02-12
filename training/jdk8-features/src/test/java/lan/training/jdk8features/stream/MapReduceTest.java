package lan.training.jdk8features.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by nik-lazer on 2/8/2016.
 */
public class MapReduceTest {
    private List<Person> persons = new ArrayList<>();

    @Before
    public void init() {
        persons.addAll(Arrays.asList(
                new Person("John", "Smith", 36),
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

    @Test
    public void maxTest() {
        Person oldest = persons.stream()
                .max((o1, o2) -> Integer.compare(o1.getAge(), o2.getAge()))
                .get();
        assertEquals(45, oldest.getAge());
        assertEquals("John", oldest.getFirstName());
        assertEquals("Doe", oldest.getLastName());
    }

    @Test
    public void intStreamTest() {
        double average = persons.stream()
                .mapToInt(value -> value.getAge())
                .filter(value1 -> value1 > 30)
                .average()
                .getAsDouble();
        assertEquals(38, average, 0.1);
    }

    @Test
    public void sortTest() {
        String ret = persons.stream()
                .sorted((o1, o2) -> Integer.compare(o1.getAge(), o2.getAge()))
                .map(person -> person.getLastName() + " " + person.getFirstName())
                .collect(Collectors.joining(", "));
        assertEquals("Smith John, Doe Jane, Smith John, Doe John", ret);
    }

    @Test
    public void manyFilters() {
        Optional<Person> firstFinded = persons.stream()
                .filter(person -> person.getAge() > 20)
                .filter(person -> person.getAge()<40)
                .filter(person -> person.getLastName().equals("Smith"))
                .filter(person -> person.getLastName().equals("Jane"))
                .findFirst();
        assertFalse(firstFinded.isPresent());
    }

}
