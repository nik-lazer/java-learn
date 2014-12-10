package lan.training.spring.util;

import lan.training.spring.model.Language;
import lan.training.spring.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.util.UUID;

/**
 * String to {@link lan.training.spring.model.Language} converter for forms
 * @author nik-lazer  10.12.2014   15:02
 */
public class LanguageConverter implements Converter<String, Language> {

	@Autowired
	LanguageService languageService;

	@Override
	public Language convert(String source) {
		UUID uuid = UUID.fromString(source);
		Language language = languageService.getById(uuid);
		return language;
	}
}
