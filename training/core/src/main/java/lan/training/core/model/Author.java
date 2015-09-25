package lan.training.core.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Author POJO
 * @author nik-lazer  09.12.2014   19:11
 */
public class Author implements IEntity {
	@Id
	@Column(columnDefinition = "BINARY(16)")
	private UUID uid;
	private String firstName;
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return firstName + " " + lastName;
	}

	@Override
	public UUID getUid() {
		return uid;
	}

	public void setUid(UUID uid) {
		this.uid = uid;
	}

}
