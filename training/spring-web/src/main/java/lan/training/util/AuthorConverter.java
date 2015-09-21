package lan.training.util;

import lan.training.model.Author;
import lan.training.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.util.UUID;

/**
 * String to {@link lan.training.model.Author} converter for forms
 * @author nik-lazer  10.12.2014   15:02
 */
public class AuthorConverter implements Converter<String, Author> {

	@Autowired
	AuthorService authorService;

	@Override
	public Author convert(String source) {
		UUID uuid = UUID.fromString(source);
		Author author = authorService.getById(uuid);
		return author;
	}
}
