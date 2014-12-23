package lan.training.hibernate.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Message POJO
 * @author nik-lazer  23.12.2014   15:54
 */
@Entity
public class Message {
	@Id
	@GeneratedValue
	private Integer id;
	public Message() {
	}
	public Message(String messageText) {
		this.messageText = messageText;
	}
	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private String messageText;
}
