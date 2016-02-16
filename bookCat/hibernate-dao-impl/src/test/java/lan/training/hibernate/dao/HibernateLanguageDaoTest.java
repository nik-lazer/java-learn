package lan.training.hibernate.dao;

import lan.training.core.dao.LanguageDao;
import lan.training.core.factory.LanguageFactory;
import lan.training.core.model.Language;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Ignore;
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
 * Test for {@link lan.training.hibernate.dao.HibernateLanguageDaoImpl}
 * @author nik-lazer  23.12.2014   16:47
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/hibernateTestDaoContext.xml"})
public class HibernateLanguageDaoTest {
	@Autowired
	LanguageDao languageDao;
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	LanguageFactory languageFactory;

	@Test
	public void getListTest() {
		List list = languageDao.getList();
		assertNotNull(list);
	}

	@Test
	public void addTest() {
		Language language = languageFactory.of(4, "jdbcAddTest");
		languageDao.add(language);
		language = languageDao.getById(4);
		assertNotNull(language);
		assertEquals("jdbcAddTest", language.getName());
	}

	@Test
	public void updateTest() {
		Language language = languageDao.getById(2);
		language = languageFactory.of(language.getUid(), "Update test");
		languageDao.update(language.getUid(), language);
		language = languageDao.getById(2);
		assertEquals("Update test", language.getName());
	}

	@Test
	public void deleteTest() {
		assertNotNull(languageDao.getById(3));
		languageDao.delete(3);
		assertNull(languageDao.getById(3));
	}


	@Test
	public void getByIdTest() {
		Language language = languageDao.getById(1);
		assertNotNull(language);
		assertEquals("English", language.getName());
	}
}
