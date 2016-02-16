package lan.training.jdbc.dao;

import lan.training.core.dao.AuthorDao;
import lan.training.core.factory.AuthorFactory;
import lan.training.core.model.Author;
import lan.training.core.model.Language;
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
public class JdbcAuthorDaoTest {

	@Autowired
	AuthorDao authorDao;
	@Autowired
	AuthorFactory authorFactory;
	@Test
	public void getListTest() {
		List<Author> list = authorDao.getList();
		assertNotNull(list);
	}

	@Test
	public void addTest() {
		Author author = authorFactory.of(4, "jdbcAddTestFirst", "jdbcAddTestLast");
		authorDao.add(author);
		author = authorDao.getById(4);
		assertNotNull(author);
		assertEquals("jdbcAddTestFirst", author.getFirstName());
		assertEquals("jdbcAddTestLast", author.getLastName());
	}

	@Test
	public void update() {
		Author author = authorDao.getById(2);
		author = authorFactory.of(author.getUid(), "Update test first", author.getLastName());
		authorDao.update(author.getUid(), author);
		author = authorDao.getById(2);
		assertEquals("Update test first", author.getFirstName());
	}

	@Test
	public void delete() {
		assertNotNull(authorDao.getById(3));
		authorDao.delete(3);
		assertNull(authorDao.getById(3));
	}

	@Test
	public void getById() {
		Author author = authorDao.getById(1);
		assertNotNull(author);
		assertEquals("Craig", author.getFirstName());
		assertEquals("Walls", author.getLastName());
	}
}
