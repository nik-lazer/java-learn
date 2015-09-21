package lan.training.dao;

import lan.training.model.Language;
import lan.training.util.DataUtil;
import org.springframework.stereotype.Service;

/**
 * Language service implementation
 * @author nik-lazer  09.12.2014   19:31
 */
@Service
public class LanguageDaoImpl extends AbstractMemoryDaoImpl<Language> implements LanguageDao {

	public LanguageDaoImpl() {
		setData(listToMap(DataUtil.getLanguages()));
	}
}
