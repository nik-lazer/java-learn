package lan.training.hibernate.dao;

import lan.training.core.dao.BookDao;
import lan.training.core.dao.LanguageDao;
import lan.training.core.model.Book;
import lan.training.core.model.Language;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Hibernate implementation for {@link BookDao}
 * @author nik-lazer  24.12.2014   09:29
 */
@Repository
public class HibernateBookDaoImpl extends AbstractHibernateDao<Book> implements BookDao {
	private static Logger log = LoggerFactory.getLogger(HibernateBookDaoImpl.class);

	@Override
	public List<Book> getList() {
		Session session = getSessionFactory().openSession();
		List list = session.createQuery("from Book").list();
		return list;
	}

	@Override
	public Book getById(Integer id) {
		return getSessionFactory().openSession().get(Book.class, id);
	}
}
