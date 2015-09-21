package lan.training.dao;

import lan.training.model.Publisher;
import lan.training.util.DataUtil;
import org.springframework.stereotype.Service;

/**
 * Publisher service implementation
 * @author nik-lazer  09.12.2014   19:31
 */
@Service
public class PublisherDaoImpl extends AbstractMemoryDaoImpl<Publisher> implements PublisherDao {

	public PublisherDaoImpl() {
		setData(listToMap(DataUtil.getPublishers()));
	}
}
