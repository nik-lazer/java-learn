package lan.training.gwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import lan.training.core.model.Publisher;
import lan.training.gwt.client.BookRemoteService;
import lan.training.gwt.client.PublisherRemoteService;
import lan.training.gwt.server.util.ServiceLocator;
import lan.training.gwt.shared.dto.PublisherDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Remote publishers service impliementation
 * @author nik-lazer  30.09.2015   12:43
 */
@SuppressWarnings("serial")
public class PublisherRemoteServiceImpl extends RemoteServiceServlet implements PublisherRemoteService {

	@Override
	public List<PublisherDto> getList() {
		List<Publisher> publisherList = ServiceLocator.getPublisherService().getList();
		List<PublisherDto> list = new ArrayList<>();
		for (Publisher publisher : publisherList) {
			PublisherDto publisherDto = new PublisherDto();
			publisherDto.setName(publisher.getName());
			publisherDto.setUid(publisher.getUid());
			publisherDto.setAddress(publisher.getAddress());
			list.add(publisherDto);
		}
		return list;
	}
}
