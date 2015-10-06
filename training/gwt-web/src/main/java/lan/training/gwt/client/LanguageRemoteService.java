package lan.training.gwt.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import lan.training.gwt.shared.dto.LanguageDto;

import java.util.List;

/**
 * Remote languages service
 * @author nik-lazer  06.10.2015   12:59
 */
@RemoteServiceRelativePath("language")
public interface LanguageRemoteService extends RemoteService {
	List<LanguageDto> getList();
}
