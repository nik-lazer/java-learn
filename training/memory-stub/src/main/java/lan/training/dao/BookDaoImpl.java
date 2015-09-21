package lan.training.dao;

import lan.training.model.Book;
import lan.training.util.DataUtil;
import org.springframework.stereotype.Service;

/**
 * Book service {@link lan.training.service.BookService} implementation
 * @author nik-lazer 03.12.2014   13:25
 */
@Service
public class BookDaoImpl extends AbstractMemoryDaoImpl<Book> implements BookDao {

	public BookDaoImpl() {
		setData(listToMap(DataUtil.getBooks()));
	}
}
