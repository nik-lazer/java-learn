package lan.training.core.factory;

import lan.training.core.model.Language;

/**
 * Created by nik-lazer on 2/15/2016.
 */
public interface LanguageFactory {
    Language of(Integer id, String name);
}
