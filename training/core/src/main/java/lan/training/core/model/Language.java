package lan.training.core.model;

import javax.persistence.*;
import java.util.UUID;

/**
 * Language POJO
 * @author nik-lazer  09.12.2014   19:09
 */
@Entity
public class Language implements IEntity {
	@Id
	@Column(columnDefinition = "BINARY(16)")
	private UUID uid;
	@Column
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public UUID getUid() {
		return uid;
	}

	public void setUid(UUID uid) {
		this.uid = uid;
	}
}
