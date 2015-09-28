package lan.training.jdbc;

import lan.training.jdbc.dao.JdbcLanguageDaoTest;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Suite for DAO tests
 * @author nik-lazer  28.09.2015   14:14
 */
@Suite.SuiteClasses(JdbcLanguageDaoTest.class)
@RunWith(Suite.class)
public class JdbcDaoSuite {
	private static final Logger logger = LoggerFactory.getLogger(JdbcDaoSuite.class);
	@BeforeClass
	public static void init() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/dbContext.xml");
	}
}
