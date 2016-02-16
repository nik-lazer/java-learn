package lan.training.hibernate.dao;

import lan.training.core.dao.AuthorDao;
import lan.training.core.factory.AuthorFactory;
import lan.training.core.model.Author;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Test for {@link HibernateAuthorDaoImpl}
 * @author nik-lazer  23.12.2014   16:47
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/hibernateTestDaoContext.xml"})
public class HibernateAuthorDaoTest {
	@Autowired
	AuthorDao authorDao;
	@Autowired
	AuthorFactory authorFactory;

	@Test
	public void getListTest() {
		List list = authorDao.getList();
		assertNotNull(list);
	}

	@Test
	public void addTest() {
		Author author = authorFactory.of(4, "jdbcAddTest", null);
		authorDao.add(author);
		author = authorDao.getById(4);
		assertNotNull(author);
		assertEquals("jdbcAddTest", author.getFirstName());
	}

	@Test
	public void updateTest() {
		Author author = authorDao.getById(2);
		author = authorFactory.of(author.getUid(), "Update test", author.getLastName());
		authorDao.update(author.getUid(), author);
		author = authorDao.getById(2);
		assertEquals("Update test", author.getFirstName());
	}

	@Test
	public void deleteTest() {
		assertNotNull(authorDao.getById(3));
		authorDao.delete(3);
		assertNull(authorDao.getById(3));
	}


	@Test
	public void getByIdTest() {
		Author author = authorDao.getById(1);
		assertNotNull(author);
		assertEquals("Craig", author.getFirstName());
	}
}
