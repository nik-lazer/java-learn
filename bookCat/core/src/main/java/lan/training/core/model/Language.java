package lan.training.core.model;

import javax.persistence.*;

/**
 * Language POJO
 * @author nik-lazer  09.12.2014   19:09
 */
@Entity
public class Language extends AbstractEntity {
	@Column
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
