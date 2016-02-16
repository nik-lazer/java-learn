package lan.training.memory.dao;

import lan.training.core.dao.LanguageDao;
import lan.training.core.model.Language;
import lan.training.memory.util.DataUtilBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

/**
 * Language service implementation
 * @author nik-lazer  09.12.2014   19:31
 */
@Repository
public class LanguageDaoImpl extends AbstractMemoryDaoImpl<Language> implements LanguageDao {
	@Autowired
	private DataUtilBean dataUtilBean;

	@PostConstruct
	public void init() {
		setData(listToMap(dataUtilBean.getLanguages()));
	}
}
