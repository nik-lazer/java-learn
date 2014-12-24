package lan.training.hibernate.dao;

import lan.training.hibernate.domain.Message;
import lan.training.hibernate.exception.MessageException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Hibernate message DAO implementation with explicit transaction starting
 * @author nik-lazer  23.12.2014   15:57
 */
@Repository("transactionalHibernateMessageDao")
public class TransactionalHibernateMessageDaoImpl implements MessageDao {
	private static Logger log = LoggerFactory.getLogger(TransactionalHibernateMessageDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List getMessages() throws MessageException {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List list = session.createQuery("from Message").list();
			tx.commit();
			tx = null;
			return list;
		} catch ( HibernateException e ) {
			if ( tx != null ) tx.rollback();
			log.error("Could not acquire message", e);
			throw new MessageException("Failed to retrieve message from the database.", e);
		} finally {
			session.close();
		}
	}

	@Override
	public void add(Message message) {

	}
}
