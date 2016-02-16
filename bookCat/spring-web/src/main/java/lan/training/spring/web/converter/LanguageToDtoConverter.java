package lan.training.spring.web.converter;

import lan.training.core.model.Language;
import lan.training.spring.web.dto.LanguageDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by nik-lazer on 2/15/2016.
 */
@Component
public class LanguageToDtoConverter implements Converter<Language, LanguageDto> {
    @Override
    public LanguageDto convert(Language source) {
        LanguageDto languageDto = new LanguageDto();
        languageDto.setUid(source.getUid());
        languageDto.setName(source.getName());
        return languageDto;
    }
}
