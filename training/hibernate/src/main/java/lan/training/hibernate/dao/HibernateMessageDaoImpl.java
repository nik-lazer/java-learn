package lan.training.hibernate.dao;

import lan.training.hibernate.exception.MessageException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

/**
 * Hibernate message DAO implementation
 * @author nik-lazer  23.12.2014   15:57
 */
@Repository
public class HibernateMessageDaoImpl {
	private static Logger log = LoggerFactory.getLogger(HibernateMessageDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List getMessages(int messageId) throws MessageException {
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
}
