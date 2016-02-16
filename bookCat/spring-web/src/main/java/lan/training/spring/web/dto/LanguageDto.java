package lan.training.spring.web.dto;

import lan.training.core.model.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Language POJO
 * @author nik-lazer  09.12.2014   19:09
 */
@Entity
public class LanguageDto extends AbstractDto {
	@Column
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
