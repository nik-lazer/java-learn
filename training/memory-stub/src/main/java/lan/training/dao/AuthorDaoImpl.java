package lan.training.dao;

import lan.training.util.DataUtil;
import lan.training.model.Author;
import org.springframework.stereotype.Service;

/**
 * Author service implementation
 * @author nik-lazer  09.12.2014   19:31
 */
@Service
public class AuthorDaoImpl extends AbstractMemoryDaoImpl<Author> implements AuthorDao {

	public AuthorDaoImpl() {
		setData(listToMap(DataUtil.getAuthors()));
	}

}
