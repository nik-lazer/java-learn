package lan.training.hibernate.dao;

import lan.training.hibernate.domain.Message;
import lan.training.hibernate.exception.MessageException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Hibernate message DAO implementation
 * @author nik-lazer  24.12.2014   09:29
 */
@Repository("hibernateMessageDao")
public class HibernateMessageDaoImpl implements MessageDao {
	private static Logger log = LoggerFactory.getLogger(TransactionalHibernateMessageDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Message> getMessages() throws MessageException {
		Session session = sessionFactory.openSession();
		List list = session.createQuery("from Message").list();
		return list;
	}

	@Override
	public void add(Message message) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(message);
	}
}
