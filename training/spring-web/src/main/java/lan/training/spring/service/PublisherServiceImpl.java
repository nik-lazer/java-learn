package lan.training.spring.service;

import lan.training.spring.model.Publisher;
import lan.training.spring.util.DataUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Publisher service implementation
 * @author nik-lazer  09.12.2014   19:31
 */
@Service
public class PublisherServiceImpl extends AbstractMemoryService implements PublisherService {
	private Map<UUID, Publisher> data;

	public PublisherServiceImpl() {
		data = listToMap(DataUtil.getPublishers());
	}

	@Override
	public List<Publisher> getList() {
		return new ArrayList<Publisher>(data.values());
	}

	@Override
	public void add(Publisher model) {
		if (model.getId() == null) {
			model.setId(UUID.randomUUID());
		}
		data.put(model.getId(), model);
	}

	@Override
	public void update(UUID id, Publisher model) {
		data.put(id, model);
	}

	@Override
	public void delete(UUID id) {
		data.remove(id);
	}

	@Override
	public Publisher getById(UUID id) {
		return data.get(id);
	}
}
