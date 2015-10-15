package lan.training.jdbc.dao;

import lan.training.core.dao.LanguageDao;
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
public class JdbcLanguageDaoTest {

	@Autowired
	LanguageDao languageDao;
	@Test
	public void getListTest() {
		List<Language> list = languageDao.getList();
		assertNotNull(list);
	}

	@Test
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
	public void update() {
		Language language = languageDao.getById(2);
		language.setName("Update test");
		languageDao.update(language.getUid(), language);
		language = languageDao.getById(2);
		assertEquals("Update test", language.getName());
	}

	@Test
	public void delete() {
		assertNotNull(languageDao.getById(3));
		languageDao.delete(3);
		assertNull(languageDao.getById(3));
	}

	@Test
	public void getById() {
		Language language = languageDao.getById(1);
		assertNotNull(language);
		assertEquals("English", language.getName());
	}
}
