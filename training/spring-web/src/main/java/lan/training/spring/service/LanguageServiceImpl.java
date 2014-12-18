package lan.training.spring.service;

import lan.training.spring.model.Language;
import lan.training.spring.util.DataUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Language service implementation
 * @author nik-lazer  09.12.2014   19:31
 */
@Service
public class LanguageServiceImpl extends AbstractMemoryService implements LanguageService {
	private Map<UUID, Language> data;

	public LanguageServiceImpl() {
		data = listToMap(DataUtil.getLanguages());
	}

	@Override
	public List<Language> getList() {
		return new ArrayList<Language>(data.values());
	}

	@Override
	public void add(Language model) {
		if (model.getId() == null) {
			model.setId(UUID.randomUUID());
		}
		data.put(model.getId(), model);
	}

	@Override
	public void update(UUID id, Language model) {
		data.put(id, model);
	}

	@Override
	public void delete(UUID id) {
		data.remove(id);
	}

	@Override
	public Language getById(UUID id) {
		return data.get(id);
	}
}