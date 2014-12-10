package lan.training.spring.model;

import java.util.UUID;

/**
 * Abstract domain with identificator
 * @author nik-lazer  10.12.2014   13:17
 */
public abstract class AbstractDomain {
	private UUID id;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
}
