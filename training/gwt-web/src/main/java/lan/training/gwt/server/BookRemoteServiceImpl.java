package lan.training.gwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import lan.training.core.model.Book;
import lan.training.gwt.client.BookRemoteService;
import lan.training.gwt.server.util.ServiceLocator;
import lan.training.gwt.shared.dto.BookDto;
import lan.training.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Remote books service impliementation
 * @author nik-lazer  30.09.2015   12:43
 */
@SuppressWarnings("serial")
public class BookRemoteServiceImpl extends RemoteServiceServlet implements BookRemoteService {

	@Override
	public List<BookDto> getList() {
		List<Book> bookList = ServiceLocator.getBookService().getList();
		List<BookDto> list = new ArrayList<>();
		for (Book book: bookList) {
			BookDto bookDto = new BookDto();
			bookDto.setName(book.getName());
			bookDto.setUid(book.getUid());
			list.add(bookDto);
		}
		return list;
	}
}
