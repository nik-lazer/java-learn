package lan.training.core.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Book POJO
 * @author nik-lazer 03.12.2014   13:15
 */
public class Book implements IEntity {
	@Id
	private Integer uid;
	@Size(min=3, max=500, message="Username must be between 3 and 500 characters long.")
	private String name;
	private Publisher publisher;
	private Author author;
	private Language language;
	private Date date;
	private String desc;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

}
