package lan.training.hibernate.dao;

import lan.training.core.dao.LanguageDao;
import lan.training.core.model.Language;
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

	@Test
	public void getListTest() {
		List list = languageDao.getList();
		assertNotNull(list);
	}

	@Test
	@Ignore
	public void addTest() {
		Language language = new Language();
		language.setUid(4);
		language.setName("jdbcAddTest");
		languageDao.add(language);
		language = languageDao.getById(4);
		assertNotNull(language);
		assertEquals("jdbcAddTest", language.getName());
	}

	@Test
	@Ignore
	public void updateTest() {
		Language language = languageDao.getById(2);
		language.setName("Update test");
		languageDao.update(language.getUid(), language);
		language = languageDao.getById(2);
		assertEquals("Update test", language.getName());
	}

	@Test
	@Ignore
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
