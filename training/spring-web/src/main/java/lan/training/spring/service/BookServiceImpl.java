package lan.training.spring.service;

import lan.training.spring.model.Book;
import lan.training.spring.util.DataUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Book service {@link lan.training.spring.service.BookService} implementation
 * @author nik-lazer 03.12.2014   13:25
 */
@Service
public class BookServiceImpl extends AbstractMemoryService implements BookService {
	private Map<UUID, Book> books;

	public BookServiceImpl() {
		books = listToMap(DataUtil.getBooks());
	}

	@Override
	public List<Book> getList() {
		return new ArrayList<Book>(books.values());
	}

	@Override
	public void add(Book book) {
		if (book.getId() == null) {
			book.setId(UUID.randomUUID());
		}
		books.put(book.getId(), book);
	}

	@Override
	public void update(UUID id, Book book) {
		books.put(id, book);
	}

	@Override
	public void delete(UUID id) {
		books.remove(id);
	}

	@Override
	public Book getById(UUID id) {
		return books.get(id);
	}
}
