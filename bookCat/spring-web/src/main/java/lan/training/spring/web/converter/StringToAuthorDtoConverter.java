package lan.training.spring.web.converter;

import lan.training.spring.web.dto.AuthorDto;
import lan.training.spring.web.service.AuthorDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

/**
 * String to {@link AuthorDto} converter for forms
 * @author nik-lazer  10.12.2014   15:02
 */
public class StringToAuthorDtoConverter implements Converter<String, AuthorDto> {

	@Autowired
	AuthorDtoService authorService;

	@Override
	public AuthorDto convert(String source) {
		int uuid = Integer.valueOf(source);
		AuthorDto author = authorService.getById(uuid);
		return author;
	}
}
