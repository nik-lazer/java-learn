package lan.test.zk.domain;

/**
 * TODO: comment
 * @author lazarev.nikolay 25.08.2014   10:30
 */
public class Person {
	private String name;
	private String surname;
	private int age;
	private Gender gender;
	private String address;

	public Person(String name, String surname, int age, Gender gender, String address) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
