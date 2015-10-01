package lan.learn.io.contact;

/**
 * Created by nik-lazer on 01.10.15.
 */
public class Contact {
	public String name;
	public int age;
	public long cellPhone;

	public Contact(String name, int age, long cellPhone) {
		this.name = name;
		this.age = age;
		this.cellPhone = cellPhone;
	}

	@Override
	public String toString() {
		return name + " " + age + " " + cellPhone + "\n";
	}
}
