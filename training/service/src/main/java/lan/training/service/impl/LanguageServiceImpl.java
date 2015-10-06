package lan.training.service.impl;

import lan.training.core.dao.LanguageDao;
import lan.training.core.model.Language;
import lan.training.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of {@link lan.training.service.LanguageService}
 * @author nik-lazer  22.09.2015   14:51
 */
@Service
public class LanguageServiceImpl implements LanguageService {
	@Autowired
	private LanguageDao languageDao;

	@Override
	public List<Language> getList() {
		return languageDao.getList();
	}

	@Override
	public void add(Language model) {
		languageDao.add(model);
	}

	@Override
	public void update(Language model) {
		languageDao.update(model.getUid(), model);
	}

	@Override
	public void delete(Language model) {
		languageDao.delete(model.getUid());
	}

	@Override
	public Language getById(int id) {
		return languageDao.getById(id);
	}
}
