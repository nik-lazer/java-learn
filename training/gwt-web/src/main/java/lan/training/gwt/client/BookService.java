package lan.training.gwt.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import lan.training.core.model.Book;

import java.util.List;

/**
 * TODO: comment
 * @author nik-lazer  30.09.2015   12:43
 */
@RemoteServiceRelativePath("book")
public interface BookService extends RemoteService {
	List<Book> getList();
}
