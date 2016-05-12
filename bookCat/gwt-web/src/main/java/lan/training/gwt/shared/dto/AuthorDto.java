package lan.training.gwt.shared.dto;

/**
 * DTO for {@link lan.training.core.model.Author}
 * @author nik-lazer  01.10.2015   11:02
 */
public class AuthorDto extends AbstractDto {
	private static final long serialVersionUID = -1302885200591163740L;
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
}
