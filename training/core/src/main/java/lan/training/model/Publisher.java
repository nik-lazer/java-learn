package lan.training.model;

/**
 * Publisher POJO
 * @author nik-lazer  09.12.2014   19:13
 */
public class Publisher extends AbstractEntity {
	private String name;
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
