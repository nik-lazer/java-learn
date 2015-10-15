package lan.training.gwt.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import lan.training.gwt.shared.dto.AuthorDto;

import java.util.List;

/**
 * Remote authors service
 * @author nik-lazer  06.10.2015   12:56
 */
@RemoteServiceRelativePath("author")
public interface AuthorRemoteService extends RemoteService {
	List<AuthorDto> getList();
}
