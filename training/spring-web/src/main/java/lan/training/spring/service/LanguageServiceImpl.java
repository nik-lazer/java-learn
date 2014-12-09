package lan.training.spring.service;

import lan.training.spring.model.Language;
import lan.training.spring.util.DataUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Language service implementation
 * @author nik-lazer  09.12.2014   19:31
 */
@Service
public class LanguageServiceImpl implements LanguageService {
	private List<Language> data;

	public LanguageServiceImpl() {
		data = new ArrayList<>(DataUtil.getLanguages());
	}

	@Override
	public List<Language> getList() {
		return data;
	}

	@Override
	public void add(Language model) {
		data.add(model);
	}

	@Override
	public void update(int id, Language model) {
		data.set(id, model);
	}

	@Override
	public void delete(Language model) {
		data.remove(model);
	}

	@Override
	public Language getById(int id) {
		return data.get(id);
	}
}
