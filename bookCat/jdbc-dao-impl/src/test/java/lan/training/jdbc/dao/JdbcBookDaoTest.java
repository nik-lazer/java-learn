package lan.training.jdbc.dao;

import lan.training.core.dao.BookDao;
import lan.training.core.model.Author;
import lan.training.core.model.Book;
import lan.training.core.model.Language;
import lan.training.core.model.Publisher;
import org.junit.Before;
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
public class JdbcBookDaoTest {

	@Autowired
	BookDao bookDao;

	Author author;
	Publisher publisher;
	Language language;

	@Before
	public void init() {
		author = new Author();
		author.setUid(1);
		publisher = new Publisher();
		publisher.setUid(1);
		language = new Language();
		language.setUid(1);
	}

	@Test
	public void getListTest() {
		List<Book> list = bookDao.getList();
		assertNotNull(list);
	}

	@Test
	public void addTest() {
		Book book = new Book();
		book.setUid(4);
		book.setName("jdbcAddTest");
		book.setDesc("desc");
		book.setAuthor(author);
		book.setPublisher(publisher);
		book.setLanguage(language);
		bookDao.add(book);
		book = bookDao.getById(4);
		assertNotNull(book);
		assertEquals("jdbcAddTest", book.getName());
	}

	@Test
	public void update() {
		Book language = bookDao.getById(2);
		language.setName("Update test");
		bookDao.update(language.getUid(), language);
		language = bookDao.getById(2);
		assertEquals("Update test", language.getName());
	}

	@Test
	public void delete() {
		assertNotNull(bookDao.getById(3));
		bookDao.delete(3);
		assertNull(bookDao.getById(3));
	}

	@Test
	public void getById() {
		Book book = bookDao.getById(1);
		assertNotNull(book);
		assertEquals("Book 1", book.getName());
		assertEquals(author.getUid(), book.getAuthor().getUid());
		assertEquals(publisher.getUid(), book.getPublisher().getUid());
		assertEquals(language.getUid(), book.getLanguage().getUid());
	}
}
