package lan.training.hibernate.dao;

import lan.training.hibernate.domain.Message;
import lan.training.hibernate.exception.MessageException;

import java.util.List;

/**
 * TMessage DAO
 * @author nik-lazer  23.12.2014   16:16
 */
public interface MessageDao {
	List<Message> getMessages() throws MessageException;
	void add(Message message);
}
