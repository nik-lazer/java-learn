package lan.training.core.factory.impl;

import lan.training.core.factory.AuthorFactory;
import lan.training.core.model.Author;
import org.springframework.stereotype.Component;

/**
 * Created by nik-lazer on 2/15/2016.
 */
@Component
public class AuthorFactoryImpl implements AuthorFactory {
    @Override
    public Author of(Integer uid, String firstName, String lastName) {
        return new Author(uid, firstName, lastName);
    }
}
