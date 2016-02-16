package lan.training.spring.web.dto;


/**
 * Publisher DTO
 * @author nik-lazer  09.12.2014   19:13
 */
public class PublisherDto extends AbstractDto {
	private String name;
	private String address;

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
