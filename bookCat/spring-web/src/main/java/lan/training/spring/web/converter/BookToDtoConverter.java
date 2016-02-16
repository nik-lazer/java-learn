package lan.training.spring.web.converter;

import lan.training.core.model.Book;
import lan.training.spring.web.dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by nik-lazer on 2/15/2016.
 */
@Component
public class BookToDtoConverter implements Converter<Book, BookDto> {
    @Autowired
    LanguageToDtoConverter languageToDtoConverter;
    @Autowired
    AuthorToDtoConverter authorToDtoConverter;
    @Autowired
    PublisherToDtoConverter publisherToDtoConverter;

    @Override
    public BookDto convert(Book book) {
        BookDto dto = new BookDto();
        dto.setUid(book.getUid());
        dto.setName(book.getName());
        dto.setPublisher(publisherToDtoConverter.convert(book.getPublisher()));
        dto.setAuthor(authorToDtoConverter.convert(book.getAuthor()));
        dto.setLanguage(languageToDtoConverter.convert(book.getLanguage()));
        dto.setDate(book.getDate());
        dto.setDesc(book.getDesc());
        return dto;
    }
}
