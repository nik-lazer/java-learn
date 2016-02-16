package lan.training.spring.web.converter;

import lan.training.core.model.Author;
import lan.training.spring.web.dto.AuthorDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by nik-lazer on 2/15/2016.
 */
@Component
public class AuthorToDtoConverter implements Converter<Author, AuthorDto> {
    @Override
    public AuthorDto convert(Author source) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setUid(source.getUid());
        authorDto.setFirstName(source.getFirstName());
        authorDto.setLastName(source.getLastName());
        return authorDto;
    }
}
