package lan.training.gwt.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import lan.training.gwt.shared.dto.BookDto;

import java.util.List;

/**
 * Remote books service
 * @author nik-lazer  30.09.2015   12:43
 */
@RemoteServiceRelativePath("book")
public interface BookRemoteService extends RemoteService {
	List<BookDto> getList();
}
