package lan.training.spring.web.dto;

/**
 * Author DTO
 * @author nik-lazer  09.12.2014   19:11
 */
public class AuthorDto extends AbstractDto {
	private String firstName;
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return firstName + " " + lastName;
	}
}
