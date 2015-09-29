package lan.training.service;

import lan.training.core.model.Book;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Test for {@link lan.training.service.BookService}
 * @author nik-lazer  22.09.2015   15:01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/dbContext.xml", "/jdbcDaoContext.xml", "/serviceContext.xml"})
public class BookServiceTest {
	@Autowired
	BookService bookService;

	@Test
	public void getListTest() {
		List<Book> list = bookService.getList();
		assertNotNull(list);
	}
}
