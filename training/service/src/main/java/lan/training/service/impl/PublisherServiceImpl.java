package lan.training.service.impl;

import lan.training.core.dao.PublisherDao;
import lan.training.core.model.Publisher;
import lan.training.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Implementation of {@link lan.training.service.PublisherService}
 * @author nik-lazer  22.09.2015   14:52
 */
@Service
public class PublisherServiceImpl implements PublisherService {
	@Autowired
	private PublisherDao publisherDao;

	@Override
	public List<Publisher> getList() {
		return publisherDao.getList();
	}

	@Override
	public void add(Publisher model) {
		publisherDao.add(model);
	}

	@Override
	public void update(Publisher model) {
		publisherDao.update(model.getId(), model);
	}

	@Override
	public void delete(Publisher model) {
		publisherDao.delete(model.getId());
	}

	@Override
	public Publisher getById(UUID id) {
		return publisherDao.getById(id);
	}
}