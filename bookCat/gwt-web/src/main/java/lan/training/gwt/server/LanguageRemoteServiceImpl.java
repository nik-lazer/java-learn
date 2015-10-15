package lan.training.gwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import lan.training.core.model.Book;
import lan.training.core.model.Language;
import lan.training.gwt.client.LanguageRemoteService;
import lan.training.gwt.server.util.ServiceLocator;
import lan.training.gwt.shared.dto.LanguageDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Remote languages service impliementation
 * @author nik-lazer  30.09.2015   12:43
 */
@SuppressWarnings("serial")
public class LanguageRemoteServiceImpl extends RemoteServiceServlet implements LanguageRemoteService {

	@Override
	public List<LanguageDto> getList() {
		List<Language> languageList = ServiceLocator.getLanguageService().getList();
		List<LanguageDto> list = new ArrayList<>();
		for (Language language : languageList) {
			LanguageDto languageDto = new LanguageDto();
			languageDto.setName(language.getName());
			languageDto.setUid(language.getUid());
			list.add(languageDto);
		}
		return list;
	}
}
