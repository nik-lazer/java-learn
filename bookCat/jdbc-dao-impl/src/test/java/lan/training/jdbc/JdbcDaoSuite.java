package lan.training.jdbc;

import lan.training.jdbc.dao.JdbcAuthorDaoTest;
import lan.training.jdbc.dao.JdbcBookDaoTest;
import lan.training.jdbc.dao.JdbcLanguageDaoTest;
import lan.training.jdbc.dao.JdbcPublisherDaoImpl;
import lan.training.jdbc.dao.JdbcPublisherDaoTest;
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
@Suite.SuiteClasses({JdbcLanguageDaoTest.class, JdbcAuthorDaoTest.class, JdbcPublisherDaoTest.class, JdbcBookDaoTest.class})
@RunWith(Suite.class)
public class JdbcDaoSuite {
	private static final Logger logger = LoggerFactory.getLogger(JdbcDaoSuite.class);
	@BeforeClass
	public static void init() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/dbContext.xml");
	}
}
