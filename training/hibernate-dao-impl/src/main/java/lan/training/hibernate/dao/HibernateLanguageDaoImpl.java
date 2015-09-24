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
import java.util.UUID;

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

	}

	@Override
	public void update(UUID id, Language model) {

	}

	@Override
	public void delete(UUID id) {

	}

	@Override
	public Language getById(UUID id) {
		return null;
	}
}
