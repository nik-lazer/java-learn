package lan.training.core.model;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Abstract entity class
 * @author nik-lazer  20.11.2015   15:00
 */
@MappedSuperclass
public abstract class AbstractEntity implements IEntity {
	@Id
	private Integer uid;

	@Override
	public Integer getUid() {
		return uid;
	}

	@Override
	public void setUid(Integer uid) {
		this.uid = uid;
	}
}
