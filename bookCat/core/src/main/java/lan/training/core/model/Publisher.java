package lan.training.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Publisher POJO
 * @author nik-lazer  09.12.2014   19:13
 */
@Entity
public class Publisher implements IEntity {
	@Id
	private Integer uid;
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
	@Override
	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

}
