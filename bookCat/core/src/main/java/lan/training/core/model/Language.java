package lan.training.core.model;

import javax.persistence.*;

/**
 * Language POJO
 * @author nik-lazer  09.12.2014   19:09
 */
@Entity
public class Language extends AbstractEntity {
	private Language() {
		super(null);
	}

	public Language(Integer id, String name) {
		super(id);
		this.name = name;
	}

	@Column
	private String name;

	public String getName() {
		return name;
	}
}
