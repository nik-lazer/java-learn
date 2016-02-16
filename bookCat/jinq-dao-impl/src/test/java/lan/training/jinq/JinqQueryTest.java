package lan.training.jinq;

import lan.training.core.model.Book;
import org.hibernate.SessionFactory;
import org.jinq.hibernate.JinqHibernateStreamProvider;
import org.jinq.jpa.JPAJinqStream;
import org.jinq.jpa.JPQL;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by nik-lazer on 2/12/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/dbContext.xml","/jinqTestDaoContext.xml"})
public class JinqQueryTest {
    @Autowired
    SessionFactory sessionFactory;
    @Before
    public void init() {

    }
    @Test
    public void firstTest() {
        JinqHibernateStreamProvider streams = new JinqHibernateStreamProvider(sessionFactory);
        List<String> list = new ArrayList<>();
        list.add("Book 1");
        list.add("Book 2");
        list.add("Book 3");
        JPAJinqStream<Book> books = streams.streamAll(sessionFactory.openSession(), Book.class)
//                .where(obj -> JPQL.isIn(obj.getName(), streams.streamAll(sessionFactory.openSession(), Book.class).select(val -> val.getName())))
                .where(obj -> obj.getAuthor().getLastName().equals("Walls"))
                .where(obj -> obj.getLanguage().getName().equals("English"));
        assertEquals(3, books.count());
    }
}
