package lan.training.hibernate;

import lan.training.hibernate.dao.HibernateMessageDaoImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Test fro messages
 * @author nik-lazer  23.12.2014   16:47
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class HibernateTest {
	@Autowired
	HibernateMessageDaoImpl hibernateMessageDao;
	@Test
	public void testMessages() {
		 hibernateMessageDao.getMessages(1);
	}
}
