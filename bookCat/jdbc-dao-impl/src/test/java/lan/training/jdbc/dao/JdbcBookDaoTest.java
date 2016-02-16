package lan.training.jdbc.dao;

import lan.training.core.dao.BookDao;
import lan.training.core.factory.AuthorFactory;
import lan.training.core.factory.BookFactory;
import lan.training.core.factory.LanguageFactory;
import lan.training.core.factory.PublisherFactory;
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

import java.util.Date;
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
	@Autowired
	BookFactory bookFactory;
	@Autowired
	LanguageFactory languageFactory;
	@Autowired
	AuthorFactory authorFactory;
	@Autowired
	PublisherFactory publisherFactory;

	Author author;
	Publisher publisher;
	Language language;

	@Before
	public void init() {
		author = authorFactory.of(1, "", "");
		publisher = publisherFactory.of(1, "", "");
		language = languageFactory.of(1, "");
	}

	@Test
	public void getListTest() {
		List<Book> list = bookDao.getList();
		assertNotNull(list);
	}

	@Test
	public void addTest() {
		Book book = bookFactory.of(4, "jdbcAddTest", publisher, author, language, new Date(), "desc");
		bookDao.add(book);
		book = bookDao.getById(4);
		assertNotNull(book);
		assertEquals("jdbcAddTest", book.getName());
	}

	@Test
	public void update() {
		Book book = bookDao.getById(2);
		book = bookFactory.of(book.getUid(), "Update test", publisher, author, language, book.getDate(), book.getDesc());
		bookDao.update(book.getUid(), book);
		book = bookDao.getById(2);
		assertEquals("Update test", book.getName());
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
