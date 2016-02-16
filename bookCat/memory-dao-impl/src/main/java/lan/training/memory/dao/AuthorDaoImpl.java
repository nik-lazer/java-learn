package lan.training.memory.dao;

import lan.training.core.dao.AuthorDao;
import lan.training.memory.util.DataUtilBean;
import lan.training.core.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

/**
 * Author service implementation
 * @author nik-lazer  09.12.2014   19:31
 */
@Repository
public class AuthorDaoImpl extends AbstractMemoryDaoImpl<Author> implements AuthorDao {
	@Autowired
	private DataUtilBean dataUtilBean;

	@PostConstruct
	public void init() {
		setData(listToMap(dataUtilBean.getAuthors()));
	}

}
