package lan.training.memory.dao;

import lan.training.core.dao.PublisherDao;
import lan.training.core.model.Publisher;
import lan.training.memory.util.DataUtilBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

/**
 * Publisher service implementation
 * @author nik-lazer  09.12.2014   19:31
 */
@Repository
public class PublisherDaoImpl extends AbstractMemoryDaoImpl<Publisher> implements PublisherDao {
	@Autowired
	private DataUtilBean dataUtilBean;

	@PostConstruct
	public void init() {
		setData(listToMap(dataUtilBean.getPublishers()));
	}
}
