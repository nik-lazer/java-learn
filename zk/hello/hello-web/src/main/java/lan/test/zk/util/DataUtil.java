package lan.test.zk.util;

import lan.test.zk.domain.Contributor;
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

	public static List<Contributor> getContributors() {
		return Arrays.asList(
				new Contributor("Arabic (ar)", "Ayman Elgharabawy", "iso-8859-6"),
				new Contributor("Indonesian (id)", "James Liam Supangkat", "iso-8859-1"),
				new Contributor("Japanese (ja)", "Poli Lee", " iso-2022-jp"),
				new Contributor("Korean (ko)", "Deok-su Lee", "euc-kr"),
				new Contributor("Turkish (tr)", "Kursat Kurt", "iso-8859-9"),
				new Contributor("Hungarian (hu)", "Andreas Klein", "iso-8859-2"),
				new Contributor("Italian (it)",	"Matteo Barbieri", "iso-8859-1"),
				new Contributor("Dutch (nl)", "Wido Jansen", "iso-8859-1"),
				new Contributor("Portuguese (pt)", "Airton Carrara", "iso-8859-1"),
				new Contributor("Romanian (ro)", "Calin Vaida", "iso-8859-2"),
				new Contributor("Russian (ru)", "Denis Yarkovoy", "iso-8859-1"),
				new Contributor("French (fr)", "Jêrôme Vergereau", "iso-8859-1"),
				new Contributor("Spanish (es)", "Daniel Octavio Ruiz Rodriguez", "iso-8859-1"),
				new Contributor("German (de)", "H.-Dirk Schmitt", "iso-8859-1"),
				new Contributor("Czech (cs)", "Pavel Mica", "iso-8859-2"),
				new Contributor("Catalan (ca)", "Xavier Covas O'Ryan", "iso-8859-1"),
				new Contributor("Bulgarian (bg)", "Boril Yonchev", "iso-8859-5"),
				new Contributor("Ukrainian (uk)", "Denis Yarkovoy", "iso-8859-5"),
				new Contributor("Swedish (sv)", "Easit AB", "iso-8859-1"),
				new Contributor("Slovenian (sl)", "Ziga", "iso-8859-2"),
				new Contributor("Brazilian Portugese (pt_BR)", "Airton Carrara", "iso-8859-1")
		);
	}
}
