package lan.training.memory.dao;

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

/**
 * Test for {@link lan.training.core.dao.LanguageDao}
 * @author nik-lazer  22.09.2015   15:24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/memoryDaoContext.xml" })
public class LanguageDaoTest {
	@Autowired
	LanguageDao languageDao;

	@Test
	public void getListTest() {
		List<Language> list = languageDao.getList();
		assertNotNull(list);
		assertEquals(2, list.size());
	}
}
