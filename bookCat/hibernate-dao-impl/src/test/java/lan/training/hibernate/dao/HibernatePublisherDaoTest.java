package lan.training.hibernate.dao;

import lan.training.core.dao.PublisherDao;
import lan.training.core.model.Publisher;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Test for {@link HibernatePublisherDaoImpl}
 * @author nik-lazer  23.12.2014   16:47
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/hibernateTestDaoContext.xml"})
public class HibernatePublisherDaoTest {
	@Autowired
	PublisherDao publisherDao;

	@Test
	public void getListTest() {
		List list = publisherDao.getList();
		assertNotNull(list);
	}

	@Test
	@Ignore
	public void addTest() {
		Publisher publisher = new Publisher();
		publisher.setUid(4);
		publisher.setName("jdbcAddTest");
		publisherDao.add(publisher);
		publisher = publisherDao.getById(4);
		assertNotNull(publisher);
		assertEquals("jdbcAddTest", publisher.getName());
	}

	@Test
	@Ignore
	public void updateTest() {
		Publisher publisher = publisherDao.getById(2);
		publisher.setName("Update test");
		publisherDao.update(publisher.getUid(), publisher);
		publisher = publisherDao.getById(2);
		assertEquals("Update test", publisher.getName());
	}

	@Test
	@Ignore
	public void deleteTest() {
		assertNotNull(publisherDao.getById(3));
		publisherDao.delete(3);
		assertNull(publisherDao.getById(3));
	}


	@Test
	public void getByIdTest() {
		Publisher publisher = publisherDao.getById(1);
		assertNotNull(publisher);
		assertEquals("English", publisher.getName());
	}
}
