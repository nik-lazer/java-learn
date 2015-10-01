package lan.training.gwt.shared.dto;

import javax.persistence.Column;

/**
 * DTO for {@link lan.training.core.model.Language}
 * @author nik-lazer  01.10.2015   11:02
 */
public class LanguageDto extends AbstractDto {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
