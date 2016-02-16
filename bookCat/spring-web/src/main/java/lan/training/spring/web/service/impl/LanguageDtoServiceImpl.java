package lan.training.spring.web.service.impl;

import lan.training.core.model.Language;
import lan.training.service.LanguageService;
import lan.training.spring.web.dto.LanguageDto;
import lan.training.spring.web.service.LanguageDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nik-lazer on 2/16/2016.
 */
@Service
public class LanguageDtoServiceImpl implements LanguageDtoService {
    @Autowired
    LanguageService languageService;
    @Autowired
    ConversionServiceFactoryBean conversionService;

    @Override
    public List<LanguageDto> getList() {
        List<Language> list = languageService.getList();
        List<LanguageDto> resultList = new ArrayList<>();
        for (Language language: list) {
            resultList.add(conversionService.getObject().convert(language, LanguageDto.class));
        }
        return resultList;
    }

    @Override
    public LanguageDto getById(Integer id) {
        Language language = languageService.getById(id);
        return conversionService.getObject().convert(language, LanguageDto.class);
    }

    @Override
    public void add(LanguageDto dto) {
        languageService.add(conversionService.getObject().convert(dto, Language.class));
    }

    @Override
    public void update(LanguageDto dto) {
        languageService.update(conversionService.getObject().convert(dto, Language.class));
    }

    @Override
    public void delete(LanguageDto dto) {
        languageService.delete(conversionService.getObject().convert(dto, Language.class));
    }
}
