package lan.training.hibernate.dao;

import lan.training.core.model.Language;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lan.training.core.dao.LanguageDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Hibernate implementation for {@link lan.training.core.dao.LanguageDao}
 * @author nik-lazer  24.12.2014   09:29
 */
@Repository
public class HibernateLanguageDaoImpl extends AbstractHibernateDao<Language> implements LanguageDao {
	private static Logger log = LoggerFactory.getLogger(HibernateLanguageDaoImpl.class);

	@Override
	public List<Language> getList() {
		Session session = getSessionFactory().openSession();
		List list = session.createQuery("from Language").list();
		return list;
	}

	@Override
	public Language getById(Integer id) {
		return getSessionFactory().openSession().get(Language.class, id);
	}
}
