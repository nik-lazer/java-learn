package lan.training.hibernate.dao;

import lan.training.core.dao.BookDao;
import lan.training.core.model.Author;
import lan.training.core.model.Book;
import lan.training.core.model.Language;
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
 * Test for {@link HibernateBookDaoImpl}
 * @author nik-lazer  23.12.2014   16:47
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/hibernateTestDaoContext.xml"})
public class HibernateBookDaoTest {
	@Autowired
	BookDao bookDao;

	@Test
	public void getListTest() {
		List list = bookDao.getList();
		assertNotNull(list);
	}

	@Test
	public void addTest() {
		Book book = new Book();
		book.setUid(4);
		book.setName("jdbcAddTest");
		Publisher publisher = new Publisher();
		publisher.setUid(1);
		book.setPublisher(publisher);
		Language language = new Language();
		language.setUid(1);
		book.setLanguage(language);
		Author author = new Author();
		author.setUid(1);
		book.setAuthor(author);
		bookDao.add(book);
		book = bookDao.getById(4);
		assertNotNull(book);
		assertEquals("jdbcAddTest", book.getName());
	}

	@Test
	public void updateTest() {
		Book book = bookDao.getById(2);
		book.setName("Update test");
		bookDao.update(book.getUid(), book);
		book = bookDao.getById(2);
		assertEquals("Update test", book.getName());
	}

	@Test
	public void deleteTest() {
		assertNotNull(bookDao.getById(3));
		bookDao.delete(3);
		assertNull(bookDao.getById(3));
	}


	@Test
	public void getByIdTest() {
		Book book = bookDao.getById(1);
		assertNotNull(book);
		assertEquals("Book 1", book.getName());
	}
}
