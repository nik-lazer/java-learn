package lan.training.core.factory.impl;

import lan.training.core.factory.BookFactory;
import lan.training.core.model.Author;
import lan.training.core.model.Book;
import lan.training.core.model.Language;
import lan.training.core.model.Publisher;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by nik-lazer on 2/15/2016.
 */
@Component
public class BookFactoryImpl implements BookFactory {
    @Override
    public Book of(Integer uid, String name, Publisher publisher, Author author, Language language, Date date, String desc) {
        return new Book(uid, name, publisher, author, language, date, desc);
    }
}
