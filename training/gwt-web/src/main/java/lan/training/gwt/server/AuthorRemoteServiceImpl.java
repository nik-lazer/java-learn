package lan.training.gwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import lan.training.core.model.Author;
import lan.training.core.model.Book;
import lan.training.gwt.client.AuthorRemoteService;
import lan.training.gwt.client.BookRemoteService;
import lan.training.gwt.server.util.ServiceLocator;
import lan.training.gwt.shared.dto.AbstractDto;
import lan.training.gwt.shared.dto.AuthorDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Remote authors service impliementation
 * @author nik-lazer  30.09.2015   12:43
 */
@SuppressWarnings("serial")
public class AuthorRemoteServiceImpl extends RemoteServiceServlet implements AuthorRemoteService {

	@Override
	public List<AuthorDto> getList() {
		List<Author> authorList = ServiceLocator.getAuthorService().getList();
		List<AuthorDto> list = new ArrayList<>();
		for (Author author : authorList) {
			AuthorDto authorDto = new AuthorDto();
			authorDto.setFirstName(author.getFirstName());
			authorDto.setUid(author.getUid());
			authorDto.setLastName(author.getLastName());
			list.add(authorDto);
		}
		return list;
	}
}
