package lan.training.spring.service;

import lan.training.spring.model.Author;
import lan.training.spring.util.DataUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Author service implementation
 * @author nik-lazer  09.12.2014   19:31
 */
@Service
public class AuthorServiceImpl extends AbstractMemoryService implements AuthorService {
	private Map<UUID, Author> data;

	public AuthorServiceImpl() {
		data = listToMap(DataUtil.getAuthors());
	}

	@Override
	public List<Author> getList() {
		return new ArrayList<Author>(data.values());
	}

	@Override
	public void add(Author model) {
		if (model.getId() == null) {
			model.setId(UUID.randomUUID());
		}
		data.put(model.getId(), model);
	}

	@Override
	public void update(UUID id, Author model) {
		data.put(id, model);
	}

	@Override
	public void delete(UUID id) {
		data.remove(id);
	}

	@Override
	public Author getById(UUID id) {
		return data.get(id);
	}
}
