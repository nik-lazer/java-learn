package lan.training.core.model;

import javax.persistence.*;

/**
 * Language POJO
 * @author nik-lazer  09.12.2014   19:09
 */
@javax.persistence.Entity
public class Language extends AbstractEntity {
	@Id
	private int uid;
	@Column
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
}
