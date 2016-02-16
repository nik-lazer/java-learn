package lan.training.jdbc.dao;

import lan.training.core.dao.PublisherDao;
import lan.training.core.factory.PublisherFactory;
import lan.training.core.model.Language;
import lan.training.core.model.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * JDBC implementation for {@link lan.training.core.dao.PublisherDao}
 * @author nik-lazer  29.09.2015   11:05
 */
@Repository
public class JdbcPublisherDaoImpl implements PublisherDao {
	private static Logger log = LoggerFactory.getLogger(JdbcPublisherDaoImpl.class);

	private JdbcTemplate jdbcTemplate;
	@Autowired
	private PublisherFactory publisherFactory;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Publisher> getList() {
		return jdbcTemplate.query("select uid, name, address from Publisher", new PublisherRowMapper());
	}

	@Override
	public void add(Publisher model) {
		jdbcTemplate.update("insert into Publisher (name, address) values (?, ?)", model.getName(), model.getAddress());
	}

	@Override
	public void update(Integer id, Publisher model) {
		jdbcTemplate.update("update Publisher set name = ?, address = ? where uid = ?", model.getName(), model.getAddress(), id);
	}

	@Override
	public void delete(Integer id) {
		jdbcTemplate.update("delete from Publisher where uid = ?", id);
	}

	@Override
	public Publisher getById(Integer id) {
		List<Publisher> list = jdbcTemplate.query("select uid, name, address from Publisher where uid = ?", new PublisherRowMapper(), id);
		return DataAccessUtils.singleResult(list);
	}

	private class PublisherRowMapper implements RowMapper<Publisher> {
		@Override
		public Publisher mapRow(ResultSet rs, int rowNum) throws SQLException {
			Publisher publisher = publisherFactory.of(rs.getInt("uid"), rs.getString("name"), rs.getString("address"));
			return publisher;
		}
	}
}
