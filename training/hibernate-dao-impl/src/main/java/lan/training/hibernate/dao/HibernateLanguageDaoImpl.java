package lan.training.hibernate.dao;

import lan.training.core.model.Language;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lan.training.core.dao.LanguageDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Hibernate implementation for {@link lan.training.core.dao.LanguageDao}
 * @author nik-lazer  24.12.2014   09:29
 */
@Repository
public class HibernateLanguageDaoImpl implements LanguageDao {
	private static Logger log = LoggerFactory.getLogger(HibernateLanguageDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Language> getList() {
		Session session = sessionFactory.openSession();
		List list = session.createQuery("from Language").list();
		return list;
	}

	@Override
	public void add(Language model) {
		Session session = sessionFactory.openSession();
		sessionFactory.openSession().saveOrUpdate(model);
	}

	@Override
	public void update(Integer id, Language model) {
		sessionFactory.openSession().update(model);
	}

	@Override
	public void delete(Integer id) {
		Language language = getById(id);
		if (language != null) {
			sessionFactory.openSession().delete(language);
		}
	}

	@Override
	public Language getById(Integer id) {
		return sessionFactory.openSession().get(Language.class, id);
	}
}
