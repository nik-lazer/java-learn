package lan.training.gwt.shared.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link lan.training.core.model.Book}
 * @author nik-lazer  01.10.2015   11:00
 */
public class BookDto extends AbstractDto {
	private String name;
	private PublisherDto publisher;
	private AuthorDto author;
	private LanguageDto language;
	private Date date;
	private String desc;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PublisherDto getPublisher() {
		return publisher;
	}

	public void setPublisher(PublisherDto publisher) {
		this.publisher = publisher;
	}

	public AuthorDto getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDto author) {
		this.author = author;
	}

	public LanguageDto getLanguage() {
		return language;
	}

	public void setLanguage(LanguageDto language) {
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
}
