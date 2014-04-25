import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Alexey Pobedyonny 28.01.2014
 */
public class Main3 {
	public static void main(String[] args) throws SQLException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		ctx.refresh();

		DataSource ds = ctx.getBean("ds", DataSource.class);
		Connection conn = ds.getConnection();
		ResultSet res = conn.prepareStatement("select complex.*, org.* from org org join complex complex where org.id=?").executeQuery();
	}
}
