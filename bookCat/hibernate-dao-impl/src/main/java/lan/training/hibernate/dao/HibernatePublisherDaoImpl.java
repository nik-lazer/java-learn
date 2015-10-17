package lan.training.hibernate.dao;

import lan.training.core.dao.PublisherDao;
import lan.training.core.model.Publisher;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Hibernate implementation for {@link PublisherDao}
 * @author nik-lazer  24.12.2014   09:29
 */
@Repository
public class HibernatePublisherDaoImpl extends AbstractHibernateDao<Publisher> implements PublisherDao {
	private static Logger log = LoggerFactory.getLogger(HibernatePublisherDaoImpl.class);

	@Override
	public List<Publisher> getList() {
		Session session = getSessionFactory().openSession();
		List list = session.createQuery("from Publisher").list();
		return list;
	}

	@Override
	public Publisher getById(Integer id) {
		return getSessionFactory().openSession().get(Publisher.class, id);
	}
}
