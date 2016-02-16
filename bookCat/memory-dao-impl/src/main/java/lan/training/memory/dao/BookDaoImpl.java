package lan.training.memory.dao;

import lan.training.core.dao.BookDao;
import lan.training.core.model.Book;
import lan.training.memory.util.DataUtilBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

/**
 * Book service {@link lan.training.core.service.BookService} implementation
 * @author nik-lazer 03.12.2014   13:25
 */
@Repository
public class BookDaoImpl extends AbstractMemoryDaoImpl<Book> implements BookDao {
	@Autowired
	private DataUtilBean dataUtilBean;

	@PostConstruct
	public void init() {
		setData(listToMap(dataUtilBean.getBooks()));
	}
}
