package lan.training.io.contact;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 * Created by nik-lazer on 02.10.15.
 */
public class ExtendedContact implements Serializable {
	private String name;
	private int age;
	private long cellPhone;
	private GregorianCalendar calendar = new GregorianCalendar();
	private transient String city;

	public ExtendedContact(String name, int age, long cellPhone, GregorianCalendar calendar, String city) {
		this.name = name;
		this.age = age;
		this.cellPhone = cellPhone;
		this.calendar = calendar;
		this.city = city;
	}

	@Override
	public String toString() {
		return name + " " + age + " " + cellPhone + "\n";
	}

	public String getCity() {
		return city;
	}
}
