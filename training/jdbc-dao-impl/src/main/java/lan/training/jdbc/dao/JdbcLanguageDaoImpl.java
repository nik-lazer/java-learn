package lan.training.jdbc.dao;

import lan.training.core.dao.LanguageDao;
import lan.training.core.model.Language;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

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
		if (model.getUid() == null) {
			Random random = new Random();
			model.setUid(random.nextInt());
		}
		jdbcTemplate.update("insert into Language (uid, name) values (?, ?)", model.getUid(), model.getName());
	}

	@Override
	public void update(Integer id, Language model) {
		jdbcTemplate.update("update Language set name = ? where uid = ?", model.getName(), id);
	}

	@Override
	public void delete(Integer id) {
		jdbcTemplate.update("delete from Language where uid = ?", id);
	}

	@Override
	public Language getById(Integer id) {
		List<Language> language = jdbcTemplate.query("select * from Language where uid = ?", new LanguageRowMapper(), id);
		return DataAccessUtils.singleResult(language);
	}

	private static class LanguageRowMapper implements RowMapper<Language> {

		@Override
		public Language mapRow(ResultSet resultSet, int i) throws SQLException {
			Language language = new Language();
			language.setUid(resultSet.getInt("uid"));
			language.setName(resultSet.getString("name"));
			return language;
		}
	}
}
