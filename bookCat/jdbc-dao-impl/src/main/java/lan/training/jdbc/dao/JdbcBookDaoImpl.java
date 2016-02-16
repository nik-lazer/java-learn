package lan.training.jdbc.dao;

import lan.training.core.dao.BookDao;
import lan.training.core.factory.AuthorFactory;
import lan.training.core.factory.BookFactory;
import lan.training.core.factory.LanguageFactory;
import lan.training.core.factory.PublisherFactory;
import lan.training.core.model.Author;
import lan.training.core.model.Book;
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
 * JDBC implementation for {@link lan.training.core.dao.BookDao}
 * @author nik-lazer  29.09.2015   11:04
 */
@Repository
public class JdbcBookDaoImpl implements BookDao {
	private static Logger log = LoggerFactory.getLogger(JdbcBookDaoImpl.class);

	private JdbcTemplate jdbcTemplate;
	@Autowired
	private BookFactory bookFactory;
	@Autowired
	private PublisherFactory publisherFactory;
	@Autowired
	private AuthorFactory authorFactory;
	@Autowired
	private LanguageFactory languageFactory;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Book> getList() {
		return jdbcTemplate.query("select b.uid, b.name, b.publisher_id, b.author_id, b.language_id, b.date, b.desc, l.uid as luid, l.name as lname, a.uid as auid, a.firstName as aFirstName, a.lastName as aLastName, p.uid as puid, p.name as pname, p.address as paddress from Book b left join Language l on l.uid=b.language_id left join Author a on a.uid=b.author_id left join Publisher p on p.uid=b.publisher_id", new BookRowMapper());
	}

	@Override
	public void add(Book model) {
		jdbcTemplate.update("insert into Book (name, publisher_id, author_id, language_id, desc) values (?, ?, ?, ?, ?)", model.getName(), model.getPublisher().getUid(), model.getAuthor().getUid(), model.getLanguage().getUid(), model.getDesc());
	}

	@Override
	public void update(Integer id, Book model) {
		jdbcTemplate.update("update Book set name = ?, publisher_id = ?, author_id = ?, language_id = ?, desc = ? where uid = ?", model.getName(), model.getPublisher().getUid(), model.getAuthor().getUid(), model.getLanguage().getUid(), model.getDesc(), id);
	}

	@Override
	public void delete(Integer id) {
		jdbcTemplate.update("delete from Book where uid = ?", id);
	}

	@Override
	public Book getById(Integer id) {
		List<Book> list = jdbcTemplate.query("select b.uid, b.name, b.publisher_id, b.author_id, b.language_id, b.date, b.desc, l.uid as luid, l.name as lname, a.uid as auid, a.firstName as aFirstName, a.lastName as aLastName, p.uid as puid, p.name as pname, p.address as paddress from Book b left join Language l on l.uid=b.language_id left join Author a on a.uid=b.author_id left join Publisher p on p.uid=b.publisher_id where uid = ?", new BookRowMapper(), id);
		return DataAccessUtils.singleResult(list);
	}

	private class BookRowMapper implements RowMapper<Book> {
		@Override
		public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
			Book book = bookFactory.of(
					rs.getInt("uid"),
					rs.getString("name"),
					(rs.getInt("publisher_id") != 0) ? publisherFactory.of(rs.getInt("puid"), rs.getString("pname"), rs.getString("paddress")) : null,
					(rs.getInt("author_id") != 0) ? authorFactory.of(rs.getInt("auid"), rs.getString("aFirstName"), rs.getString("aLastName")) : null,
					(rs.getInt("language_id") != 0) ? languageFactory.of(rs.getInt("luid"), rs.getString("lname")) : null,
					rs.getDate("date"),
					rs.getString("desc")
			);
			return book;
		}
	}
}
