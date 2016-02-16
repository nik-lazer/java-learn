package lan.training.spring.web.converter;

import lan.training.spring.web.dto.LanguageDto;
import lan.training.spring.web.service.LanguageDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

/**
 * String to {@link lan.training.core.model.Language} converter for forms
 * @author nik-lazer  10.12.2014   15:02
 */
public class StringToLanguageDtoConverter implements Converter<String, LanguageDto> {

	@Autowired
	LanguageDtoService languageService;

	@Override
	public LanguageDto convert(String source) {
		int uuid = Integer.valueOf(source);
		LanguageDto language = languageService.getById(uuid);
		return language;
	}
}
