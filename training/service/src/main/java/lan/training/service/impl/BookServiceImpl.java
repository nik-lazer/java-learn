package lan.training.service.impl;

import lan.training.core.dao.BookDao;
import lan.training.core.model.Book;
import lan.training.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Implementation of {@link lan.training.service.BookService}
 * @author nik-lazer  22.09.2015   14:51
 */
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;

	@Override
	public List<Book> getList() {
		return bookDao.getList();
	}

	@Override
	public void add(Book model) {
		bookDao.add(model);
	}

	@Override
	public void update(Book model) {
		bookDao.update(model.getId(), model);
	}

	@Override
	public void delete(Book model) {
		bookDao.delete(model.getId());
	}

	@Override
	public Book getById(UUID id) {
		return bookDao.getById(id);
	}
}
