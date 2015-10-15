package lan.training.service.converter;

import lan.training.core.model.Language;
import lan.training.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.util.UUID;

/**
 * String to {@link lan.training.core.model.Language} converter for forms
 * @author nik-lazer  10.12.2014   15:02
 */
public class LanguageConverter implements Converter<String, Language> {

	@Autowired
	LanguageService languageService;

	@Override
	public Language convert(String source) {
		int uuid = Integer.valueOf(source);
		Language language = languageService.getById(uuid);
		return language;
	}
}
