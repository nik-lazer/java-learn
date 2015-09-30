package lan.training.gwt.server;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import lan.training.core.model.Book;
import lan.training.gwt.client.BookService;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: comment
 * @author nik-lazer  30.09.2015   12:43
 */
@SuppressWarnings("serial")
public class BookServiceImpl extends RemoteServiceServlet implements BookService {

	@Override
	public List<Book> getList() {
		return new ArrayList<>();
	}
}
