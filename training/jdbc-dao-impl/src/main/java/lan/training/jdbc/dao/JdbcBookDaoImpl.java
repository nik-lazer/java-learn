package lan.training.jdbc.dao;

import lan.training.core.dao.BookDao;
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
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Book> getList() {
		return jdbcTemplate.query("select uid, name, publisher_id, author_id, language_id, date, desc from Book", new BookRowMapper());
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
		List<Book> list = jdbcTemplate.query("select uid, name, publisher_id, author_id, language_id, date, desc from Book where uid = ?", new BookRowMapper(), id);
		return DataAccessUtils.singleResult(list);
	}

	private class BookRowMapper implements RowMapper<Book> {
		@Override
		public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
			Book book = new Book();
			book.setUid(rs.getInt("uid"));
			book.setName(rs.getString("name"));
			Publisher publisher = new Publisher();
			publisher.setUid(rs.getInt("publisher_id"));
			book.setPublisher(publisher);
			Author author = new Author();
			author.setUid(rs.getInt("author_id"));
			book.setAuthor(author);
			Language language = new Language();
			language.setUid(rs.getInt("language_id"));
			book.setLanguage(language);
			book.setDate(rs.getDate("date"));
			book.setDesc(rs.getString("desc"));
			return book;
		}
	}
}
