package lan.training.core.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Publisher POJO
 * @author nik-lazer  09.12.2014   19:13
 */
public class Publisher implements IEntity {
	@Id
	@Column(columnDefinition = "BINARY(16)")
	private UUID uid;
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
	@Override
	public UUID getUid() {
		return uid;
	}

	public void setUid(UUID uid) {
		this.uid = uid;
	}

}
