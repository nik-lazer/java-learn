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

/**
 * Test for {@link lan.training.hibernate.dao.HibernateLanguageDaoImpl}
 * @author nik-lazer  23.12.2014   16:47
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/dbContext.xml", "/hibernateDaoContext.xml"})
public class HibernateLanguageDaoTest {
	@Autowired
	LanguageDao languageDao;

	@Test
	public void getListTest() {
		List list = languageDao.getList();
		assertEquals("Must be 3", 3, list.size());
	}

	@Test
	@Ignore
	public void getByIdTest() {
		Language language = new Language();
		int uuid = 1;
		language.setUid(uuid);
		language.setName("getByIdTest");
		languageDao.add(language);
		Language finded = languageDao.getById(uuid);
		assertNotNull(finded);
		assertEquals(language.getName(), finded.getName());
	}
}
