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

	private Publisher() {
		super(null);
	}

	public Publisher(Integer uid, String name, String address) {
		super(uid);
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}
}
