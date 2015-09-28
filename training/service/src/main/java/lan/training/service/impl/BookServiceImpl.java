package lan.training.service.impl;

import lan.training.core.dao.BookDao;
import lan.training.core.model.Book;
import lan.training.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
		bookDao.update(model.getUid(), model);
	}

	@Override
	public void delete(Book model) {
		bookDao.delete(model.getUid());
	}

	@Override
	public Book getById(int id) {
		return bookDao.getById(id);
	}
}
