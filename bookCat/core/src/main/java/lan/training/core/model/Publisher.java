package lan.training.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Publisher POJO
 * @author nik-lazer  09.12.2014   19:13
 */
@Entity
public class Publisher extends AbstractEntity {
	@Column
	private String name;
	@Column
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
