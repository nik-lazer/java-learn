import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Alexey Pobedyonny 28.01.2014
 */
public class Main2 {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		ctx.refresh();

		JdbcTemplate template = new JdbcTemplate(ctx.getBean("ds", DataSource.class));
		template.query("select * from Org", new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Org(rs.getString("systemName"), rs.getString("name"));
			}
		});
	}
}
