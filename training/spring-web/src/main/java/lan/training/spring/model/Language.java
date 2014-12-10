package lan.training.spring.model;

/**
 * Language POJO
 * @author nik-lazer  09.12.2014   19:09
 */
public class Language extends AbstractDomain {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
