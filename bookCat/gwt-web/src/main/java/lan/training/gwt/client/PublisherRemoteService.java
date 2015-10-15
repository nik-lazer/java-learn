package lan.training.gwt.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import lan.training.gwt.shared.dto.PublisherDto;

import java.util.List;

/**
 * Remote publishers service
 * @author nik-lazer  06.10.2015   12:59
 */
@RemoteServiceRelativePath("publisher")
public interface PublisherRemoteService extends RemoteService {
	List<PublisherDto> getList();
}
