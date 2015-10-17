package lan.training.hibernate.dao;

import lan.training.core.dao.AuthorDao;
import lan.training.core.model.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Hibernate implementation for {@link AuthorDao}
 * @author nik-lazer  24.12.2014   09:29
 */
@Repository
public class HibernateAuthorDaoImpl extends AbstractHibernateDao<Author> implements AuthorDao {
	private static Logger log = LoggerFactory.getLogger(HibernateAuthorDaoImpl.class);

	@Override
	public List<Author> getList() {
		Session session = getSessionFactory().openSession();
		List list = session.createQuery("from Author").list();
		return list;
	}

	@Override
	public Author getById(Integer id) {
		return getSessionFactory().openSession().get(Author.class, id);
	}
}
