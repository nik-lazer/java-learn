package lan.training.jdbc.dao;

import lan.training.core.dao.LanguageDao;
import lan.training.core.model.Language;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * JDBC Message DAO implementation
 * @author nik-lazer  23.12.2014   16:01
 */
@Repository
public class JdbcLanguageDaoImpl implements LanguageDao {
	private static Logger log = LoggerFactory.getLogger(JdbcLanguageDaoImpl.class);

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Language> getList() {
		return jdbcTemplate.query("select uid, name from Language", new LanguageRowMapper());
	}

	@Override
	public void add(Language model) {
		jdbcTemplate.update("insert into Language (uid, name) values (UUID(), ?)", model.getName());
	}

	@Override
	public void update(UUID id, Language model) {
		jdbcTemplate.update("update Language set name = ? where uid = ?", model.getName(), id);
	}

	@Override
	public void delete(UUID id) {
		jdbcTemplate.update("delete from Language where uid = ?", id);
	}

	@Override
	public Language getById(UUID id) {
		Language language = jdbcTemplate.queryForObject("select * from Language where uid = ?", new Object[] {id}, new LanguageRowMapper());
		return language;
	}

	private static class LanguageRowMapper implements RowMapper<Language> {

		@Override
		public Language mapRow(ResultSet resultSet, int i) throws SQLException {
			Language language = new Language();
			language.setUid(UUID.nameUUIDFromBytes(resultSet.getBytes("uid")));
			language.setName(resultSet.getString("name"));
			return language;
		}
	}
}
