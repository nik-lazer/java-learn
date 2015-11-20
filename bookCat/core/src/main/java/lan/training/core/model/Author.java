package lan.training.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Author POJO
 * @author nik-lazer  09.12.2014   19:11
 */
@Entity
public class Author extends AbstractEntity {
	@Column
	private String firstName;
	@Column
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
}
