package lan.training.core.model;

import javax.persistence.*;

/**
 * Language POJO
 * @author nik-lazer  09.12.2014   19:09
 */
@Entity
public class Language implements IEntity {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uid;
	@Column
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}
}
