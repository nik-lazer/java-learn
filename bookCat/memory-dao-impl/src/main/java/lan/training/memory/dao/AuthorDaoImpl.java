package lan.training.memory.dao;

import lan.training.core.dao.AuthorDao;
import lan.training.memory.util.DataUtil;
import lan.training.core.model.Author;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Author service implementation
 * @author nik-lazer  09.12.2014   19:31
 */
@Repository
public class AuthorDaoImpl extends AbstractMemoryDaoImpl<Author> implements AuthorDao {

	public AuthorDaoImpl() {
		setData(listToMap(DataUtil.getAuthors()));
	}

}
