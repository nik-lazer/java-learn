package lan.training.core.factory;

import lan.training.core.model.Author;
import lan.training.core.model.Book;
import lan.training.core.model.Language;
import lan.training.core.model.Publisher;

import java.util.Date;

/**
 * Created by nik-lazer on 2/15/2016.
 */
public interface BookFactory {
    Book of(Integer uid, String name, Publisher publisher, Author author, Language language, Date date, String desc);
}
