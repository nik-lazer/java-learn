package lan.training.memory.dao;

import lan.training.core.dao.BookDao;
import lan.training.core.model.Book;
import lan.training.memory.util.DataUtil;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Book service {@link lan.training.core.service.BookService} implementation
 * @author nik-lazer 03.12.2014   13:25
 */
@Repository
public class BookDaoImpl extends AbstractMemoryDaoImpl<Book> implements BookDao {

	public BookDaoImpl() {
		setData(listToMap(DataUtil.getBooks()));
	}
}
