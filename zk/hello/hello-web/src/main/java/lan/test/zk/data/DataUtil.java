package lan.test.zk.data;

import lan.test.zk.domain.Gender;
import lan.test.zk.domain.Person;

import java.util.Arrays;
import java.util.List;

/**
 * Data source for listboxes
 * @author lazarev.nikolay 17.10.2014   15:21
 */
public class DataUtil {
	public static List<Person> getPersons() {
		return Arrays.asList(
				new Person("Peter", "Smith", 27, Gender.MALE, "Newcastle, Oak street, 56"),
				new Person("Jane", "Poridge", 25, Gender.FEMALE, "London, Harley street, 12"),
				new Person("James", "Watson", 33, Gender.MALE, "Berkley street, 15"),
				new Person("Sherlok", "Holms", 35, Gender.MALE, "Berkley street, 15"),
				new Person("Thomas", "Tailor", 45, Gender.MALE, "New-York, Broadway street, 100"),
				new Person("Samanta", "Smith", 21, Gender.FEMALE, "York, Yew street, 135"),
				new Person("Fred", "Newman", 54, Gender.MALE, "London, 6 Avenue, 29")
		);
	}
}
