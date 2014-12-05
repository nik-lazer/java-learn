package lan.training.spring.service;

import lan.training.spring.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for managing of books
 * @author nik-lazer 03.12.2014   13:15
 */
public interface BookService {
	List<Book> getBooks();
	void addBook(Book book);
	void updateBook(int id, Book book);
	void deleteBook(Book book);
	Book getById(int id);
}
