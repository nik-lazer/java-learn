package lan.training.gwt.shared.dto;

/**
 * DTO for {@link lan.training.core.model.Publisher}
 * @author nik-lazer  01.10.2015   11:03
 */
public class PublisherDto extends AbstractDto {
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
