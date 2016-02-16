package lan.training.core.factory.impl;

import lan.training.core.factory.LanguageFactory;
import lan.training.core.model.Language;
import org.springframework.stereotype.Component;

/**
 * Created by nik-lazer on 2/15/2016.
 */
@Component
public class LanguageFactoryImpl implements LanguageFactory {
    @Override
    public Language of(Integer id, String name) {
        return new Language(id, name);
    }
}
