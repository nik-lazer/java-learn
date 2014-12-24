package lan.training.hibernate;

import lan.training.hibernate.dao.HibernateMessageDaoImpl;
import lan.training.hibernate.dao.TransactionalHibernateMessageDaoImpl;
import lan.training.hibernate.dao.MessageDao;
import lan.training.hibernate.domain.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Test fro messages
 * @author nik-lazer  23.12.2014   16:47
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class HibernateTest {
	@Autowired
	MessageDao hibernateMessageDao;
	@Autowired
	MessageDao transactionalHibernateMessageDao;

	private void addMessages(MessageDao dao) {
		Message message = new Message("first");
		dao.add(message);
		message = new Message("second");
		dao.add(message);
	}

	@Test
	public void testMessages() {
		addMessages(hibernateMessageDao);
		List list = hibernateMessageDao.getMessages();
		assertEquals("Must be 2", 2, list.size());
	}

	@Test
	public void testManualTransactionalMessages() {
		addMessages(transactionalHibernateMessageDao);
		List list = transactionalHibernateMessageDao.getMessages();
		assertEquals("Must be 0", 0, list.size());
	}
}
