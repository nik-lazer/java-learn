package lan.training.jdbc.dao;

import lan.training.core.dao.AuthorDao;
import lan.training.core.model.Author;
import lan.training.core.model.Language;
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
 * JDBC implementation for {@link lan.training.core.dao.AuthorDao}
 * @author nik-lazer  29.09.2015   11:05
 */
@Repository
public class JdbcAuthorDaoImpl implements AuthorDao {
	private static Logger log = LoggerFactory.getLogger(JdbcAuthorDaoImpl.class);
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Author> getList() {
		return jdbcTemplate.query("select uid, firstName, lastName from Author", new AuthorRowMapper());
	}

	@Override
	public void add(Author model) {
		jdbcTemplate.update("insert into Author (firstName, lastName) values (?, ?)", model.getFirstName(), model.getLastName());
	}

	@Override
	public void update(Integer id, Author model) {
		jdbcTemplate.update("update Author set firstName = ?, lastName = ? where uid = ?", model.getFirstName(), model.getLastName(), id);
	}

	@Override
	public void delete(Integer id) {
		jdbcTemplate.update("delete from Author where uid = ?", id);
	}

	@Override
	public Author getById(Integer id) {
		List<Author> list = jdbcTemplate.query("select uid, firstName, lastName from Author where uid = ?", new AuthorRowMapper(), id);
		return DataAccessUtils.singleResult(list);
	}

	private class AuthorRowMapper implements RowMapper<Author> {
		@Override
		public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
			Author author = new Author();
			author.setUid(rs.getInt("uid"));
			author.setFirstName(rs.getString("firstName"));
			author.setLastName(rs.getString("lastName"));
			return author;
		}
	}
}
