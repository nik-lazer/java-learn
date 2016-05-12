package lan.training.spring.web.converter;

import lan.training.core.factory.LanguageFactory;
import lan.training.core.model.Language;
import lan.training.spring.web.dto.LanguageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by nik-lazer on 2/16/2016.
 */
public class LanguageDtoToEntityConverter implements Converter<LanguageDto, Language> {
    @Autowired
    LanguageFactory languageFactory;
    @Override
    public Language convert(LanguageDto source) {
        return languageFactory.of(source.getUid(), source.getName());
    }
}
