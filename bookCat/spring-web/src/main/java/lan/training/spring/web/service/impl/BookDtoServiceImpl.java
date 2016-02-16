package lan.training.spring.web.service.impl;

import lan.training.core.model.Book;
import lan.training.service.BookService;
import lan.training.spring.web.dto.BookDto;
import lan.training.spring.web.service.BookDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nik-lazer on 2/16/2016.
 */
@Service
public class BookDtoServiceImpl implements BookDtoService {
    @Autowired
    BookService bookService;
    @Autowired
    ConversionServiceFactoryBean conversionService;

    @Override
    public List<BookDto> getList() {
        List<Book> bookList = bookService.getList();
        List<BookDto> resultList = new ArrayList<>();
        for (Book book: bookList) {
            resultList.add(conversionService.getObject().convert(book, BookDto.class));
        }
        return resultList;
    }

    @Override
    public BookDto getById(Integer id) {
        Book book = bookService.getById(id);
        return conversionService.getObject().convert(book, BookDto.class);
    }

    @Override
    public void add(BookDto dto) {
        bookService.add(conversionService.getObject().convert(dto, Book.class));
    }

    @Override
    public void update(BookDto dto) {
        bookService.update(conversionService.getObject().convert(dto, Book.class));
    }

    @Override
    public void delete(BookDto dto) {
        bookService.delete(conversionService.getObject().convert(dto, Book.class));
    }
}
