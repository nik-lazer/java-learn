package lan.training.spring.service;

import lan.training.spring.model.Book;
import lan.training.spring.util.DataUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Book service {@link lan.training.spring.service.BookService} implementation
 * @author nik-lazer 03.12.2014   13:25
 */
@Service
public class BookServiceImpl implements BookService {
	private List<Book> books;

	public BookServiceImpl() {
		books = new ArrayList<>(DataUtil.getBooks());
	}

	@Override
	public List<Book> getBooks() {
		return books;
	}

	@Override
	public void addBook(Book book) {
		books.add(book);
	}

	@Override
	public void updateBook(int id, Book book) {
		Book book1 = books.get(id);
		books.set(id, book);
	}

	@Override
	public void deleteBook(Book book) {
		books.remove(book);
	}

	@Override
	public Book getById(int id) {
		return books.get(id);
	}
}
