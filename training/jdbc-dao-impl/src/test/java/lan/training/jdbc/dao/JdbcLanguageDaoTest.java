package lan.training.jdbc.dao;

import lan.training.core.dao.LanguageDao;
import lan.training.core.model.Language;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

/**
 * Created by nik-lazer on 26.09.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/dbContext.xml", "/jdbcDaoContext.xml"})
public class JdbcLanguageDaoTest {

	@Autowired
	LanguageDao languageDao;
	@Test
	public void getListTest() {
		List<Language> list = languageDao.getList();
		assertEquals(2, list.size());
	}

	@Test
	public void addTest() {
		Language language = new Language();
		language.setName("jdbcTest");
		languageDao.add(language);
		List<Language> list = languageDao.getList();
		assertEquals(3, list.size());
	}

	@Test
	public void update() {

	}

	@Test
	public void delete() {

	}

	@Test
	public void getById() {

	}
}
