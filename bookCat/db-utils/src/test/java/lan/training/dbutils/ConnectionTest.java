package lan.training.dbutils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Test for db structure
 * @author nik-lazer  24.09.2015   15:08
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/dbContext.xml"})
public class ConnectionTest {
	@Autowired
	private DataSource dataSource;

	@Test
	public void testData() {
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(dataSource);
		List list = template.query("select * from Language", new RowMapper<String>() {
			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString("name");
			}
		});
		assertEquals(3, list.size());
	}

	@Test
	public void simpleTest() {
		String user = "sa";
		String password = "";
		String url = "jdbc:hsqldb:mem:books";
		String driver = "org.hsqldb.jdbcDriver";
		try {
			Class.forName(driver);
			Connection c = DriverManager.getConnection(url, user, password);
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery("select * from Language");
			List<String> list = new ArrayList<>();
			while(rs.next()){
				list.add(rs.getString("name"));
			}
			assertEquals(3, list.size());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
