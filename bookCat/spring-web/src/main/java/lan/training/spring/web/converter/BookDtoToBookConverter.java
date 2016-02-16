package lan.training.spring.web.converter;

import lan.training.core.factory.BookFactory;
import lan.training.core.model.Author;
import lan.training.core.model.Book;
import lan.training.core.model.Language;
import lan.training.core.model.Publisher;
import lan.training.spring.web.dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by nik-lazer on 2/16/2016.
 */
public class BookDtoToBookConverter implements Converter<BookDto, Book> {
    @Autowired
    BookFactory bookFactory;
    @Autowired
    ConversionServiceFactoryBean conversionService;
    @Override
    public Book convert(BookDto source) {
        return bookFactory.of(source.getUid(), source.getName(),
                conversionService.getObject().convert(source.getPublisher(), Publisher.class),
                conversionService.getObject().convert(source.getAuthor(), Author.class),
                conversionService.getObject().convert(source.getLanguage(), Language.class),
                source.getDate(), source.getDesc());
    }
}
