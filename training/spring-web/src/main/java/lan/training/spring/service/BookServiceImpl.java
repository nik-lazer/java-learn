package lan.training.spring.service;

import lan.training.spring.model.Book;
import lan.training.spring.util.DataUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO: comment
 * @author nik-lazer 03.12.2014   13:25
 */
@Service
public class BookServiceImpl implements BookService {
	@Override
	public List<Book> getBooks() {
		return DataUtil.getBooks();
	}
}
