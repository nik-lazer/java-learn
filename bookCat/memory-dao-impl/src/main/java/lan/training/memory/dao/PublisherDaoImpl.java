package lan.training.memory.dao;

import lan.training.core.dao.PublisherDao;
import lan.training.core.model.Publisher;
import lan.training.memory.util.DataUtil;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Publisher service implementation
 * @author nik-lazer  09.12.2014   19:31
 */
@Repository
public class PublisherDaoImpl extends AbstractMemoryDaoImpl<Publisher> implements PublisherDao {

	public PublisherDaoImpl() {
		setData(listToMap(DataUtil.getPublishers()));
	}
}
