package lan.training.hibernate.dao;

import lan.training.hibernate.exception.MessageException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * JDBC Message DAO implementation
 * @author nik-lazer  23.12.2014   16:01
 */
public class JdbcMessageDaoImpl implements MessageDao {
	private static Logger log = LoggerFactory.getLogger(JdbcMessageDaoImpl.class);
	public List getMessages(int messageId) throws MessageException {
		Connection c = null;
		PreparedStatement p = null;
		List list = new ArrayList();
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection(
					"jdbc:hsqldb:testdb;shutdown=true",
					"hibernate",
					"hibernate");
			p = c.prepareStatement(
					"select message from messages");
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				String text = rs.getString(1);
				list.add(new lan.training.hibernate.domain.Message(text));
			}
			return list;
		} catch (Exception e) {
			log.error("Could not acquire message", e);
			throw new MessageException("Failed to retrieve message from the database.", e);
		} finally {
			if (p != null) {
				try {
					p.close();
				} catch (SQLException e) {
					log.error("Could not close ostensibly open statement.", e);
				}
			}
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					log.error("Could not close ostensibly open connection.", e);
				}
			}
		}
	}
}
