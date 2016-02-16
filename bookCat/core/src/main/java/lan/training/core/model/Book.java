package lan.training.core.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Book POJO
 * @author nik-lazer 03.12.2014   13:15
 */
@Entity
public class Book extends AbstractEntity {
	@Column
	private String name;
	@ManyToOne
	@JoinColumn(name = "publisher_id")
	private Publisher publisher;
	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;
	@ManyToOne
	@JoinColumn(name = "language_id")
	private Language language;
	@Column
	private Date date;
	@Column
	private String desc;

	private Book() {
		super(null);
	}

	public Book(Integer uid, String name, Publisher publisher, Author author, Language language, Date date, String desc) {
		super(uid);
		this.name = name;
		this.publisher = publisher;
		this.author = author;
		this.language = language;
		this.date = date;
		this.desc = desc;
	}

	public String getName() {
		return name;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public Author getAuthor() {
		return author;
	}

	public Language getLanguage() {
		return language;
	}

	public Date getDate() {
		return date;
	}

	public String getDesc() {
		return desc;
	}
}
