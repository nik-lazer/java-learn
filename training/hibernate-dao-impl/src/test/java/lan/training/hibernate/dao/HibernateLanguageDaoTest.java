package lan.training.hibernate.dao;

import lan.training.core.dao.LanguageDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

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
	public void testList() {
		List list = languageDao.getList();
		assertEquals("Must be 2", 2, list.size());
	}
}
