package lan.training.core.factory;

import lan.training.core.model.Author;

/**
 * Created by nik-lazer on 2/15/2016.
 */
public interface AuthorFactory {
    Author of(Integer uid, String firstName, String lastName);
}
