package lan.training.memory.dao;

import lan.training.core.dao.LanguageDao;
import lan.training.core.model.Language;
import lan.training.memory.util.DataUtil;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Language service implementation
 * @author nik-lazer  09.12.2014   19:31
 */
@Repository
public class LanguageDaoImpl extends AbstractMemoryDaoImpl<Language> implements LanguageDao {

	public LanguageDaoImpl() {
		setData(listToMap(DataUtil.getLanguages()));
	}
}
