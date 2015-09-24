package lan.training.jdbc.dao;

import lan.training.core.dao.LanguageDao;
import lan.training.core.model.Language;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
public class JdbcLanguageDaoImpl implements LanguageDao {
	private static Logger log = LoggerFactory.getLogger(JdbcLanguageDaoImpl.class);

	@Override
	public List<Language> getList() {
		return null;
	}

	@Override
	public void add(Language model) {

	}

	@Override
	public void update(UUID id, Language model) {

	}

	@Override
	public void delete(UUID id) {

	}

	@Override
	public Language getById(UUID id) {
		return null;
	}
}
