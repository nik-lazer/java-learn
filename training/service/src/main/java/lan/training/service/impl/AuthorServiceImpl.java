package lan.training.service.impl;

import lan.training.core.dao.AuthorDao;
import lan.training.core.model.Author;
import lan.training.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Implementation of {@link lan.training.service.AuthorService}
 * @author nik-lazer  22.09.2015   14:48
 */
@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorDao authorDao;

	@Override
	public List<Author> getList() {
		return authorDao.getList();
	}

	@Override
	public void add(Author model) {
		authorDao.add(model);
	}

	@Override
	public void update(Author model) {
		authorDao.update(model.getId(), model);
	}

	@Override
	public void delete(Author model) {
		authorDao.delete(model.getId());
	}

	@Override
	public Author getById(UUID id) {
		return authorDao.getById(id);
	}
}
