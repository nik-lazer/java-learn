package lan.training.hibernate;

import lan.training.hibernate.dao.HibernateAuthorDaoTest;
import lan.training.hibernate.dao.HibernateBookDaoTest;
import lan.training.hibernate.dao.HibernateLanguageDaoTest;
import lan.training.hibernate.dao.HibernatePublisherDaoTest;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Suite for DAO tests
 * @author nik-lazer  12.10.2015   15:31
 */
@Suite.SuiteClasses({HibernateLanguageDaoTest.class, HibernateBookDaoTest.class, HibernateAuthorDaoTest.class, HibernatePublisherDaoTest.class})
@RunWith(Suite.class)
public class HibernateDaoSuite {
	private static final Logger logger = LoggerFactory.getLogger(HibernateDaoSuite.class);

	@BeforeClass
	public static void init() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/dbContext.xml");
	}

}
