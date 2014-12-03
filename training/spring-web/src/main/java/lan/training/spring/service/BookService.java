package lan.training.spring.service;

import lan.training.spring.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO: comment
 * @author nik-lazer 03.12.2014   13:15
 */
public interface BookService {
	List<Book> getBooks();
}
