package lan.training.spring.web.dto;

import lan.training.core.model.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Book DTO
 * @author nik-lazer 03.12.2014   13:15
 */
@Entity
public class BookDto extends AbstractDto {
	@Size(min=3, max=500, message="Username must be between 3 and 500 characters long.")
	private String name;
	private PublisherDto publisher;
	private AuthorDto author;
	private LanguageDto language;
	private Date date;
	private String desc;

	public String getName() {
		return name;
	}

	public PublisherDto getPublisher() {
		return publisher;
	}

	public AuthorDto getAuthor() {
		return author;
	}

	public LanguageDto getLanguage() {
		return language;
	}

	public Date getDate() {
		return date;
	}

	public String getDesc() {
		return desc;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPublisher(PublisherDto publisher) {
		this.publisher = publisher;
	}

	public void setAuthor(AuthorDto author) {
		this.author = author;
	}

	public void setLanguage(LanguageDto language) {
		this.language = language;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
