package lan.training.jdbc.dao;

import lan.training.core.dao.PublisherDao;
import lan.training.core.factory.PublisherFactory;
import lan.training.core.model.Publisher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by nik-lazer on 26.09.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/jdbcTestDaoContext.xml"})
public class JdbcPublisherDaoTest {

	@Autowired
	PublisherDao publisherDao;
	@Autowired
	PublisherFactory publisherFactory;
	@Test
	public void getListTest() {
		List<Publisher> list = publisherDao.getList();
		assertNotNull(list);
	}

	@Test
	public void addTest() {
		Publisher publisher = publisherFactory.of(4, "jdbcAddTest", null);
		publisherDao.add(publisher);
		publisher = publisherDao.getById(4);
		assertNotNull(publisher);
		assertEquals("jdbcAddTest", publisher.getName());
	}

	@Test
	public void update() {
		Publisher publisher = publisherDao.getById(2);
		publisher = publisherFactory.of(publisher.getUid(), "Update test", publisher.getAddress());
		publisherDao.update(publisher.getUid(), publisher);
		publisher = publisherDao.getById(2);
		assertEquals("Update test", publisher.getName());
	}

	@Test
	public void delete() {
		assertNotNull(publisherDao.getById(3));
		publisherDao.delete(3);
		assertNull(publisherDao.getById(3));
	}

	@Test
	public void getById() {
		Publisher publisher = publisherDao.getById(1);
		assertNotNull(publisher);
		assertEquals("O'Reily", publisher.getName());
	}
}
