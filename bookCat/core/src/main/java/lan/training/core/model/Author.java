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

	private Author() {
		super(null);
	}

	public Author(Integer uid, String firstName, String lastName) {
		super(uid);
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getName() {
		return firstName + " " + lastName;
	}
}
