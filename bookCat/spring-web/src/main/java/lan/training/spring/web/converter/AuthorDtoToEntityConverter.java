package lan.training.spring.web.converter;

import lan.training.core.factory.AuthorFactory;
import lan.training.core.model.Author;
import lan.training.spring.web.dto.AuthorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by nik-lazer on 2/16/2016.
 */
public class AuthorDtoToEntityConverter implements Converter<AuthorDto, Author> {
    @Autowired
    AuthorFactory authorFactory;
    @Override
    public Author convert(AuthorDto source) {
        return authorFactory.of(source.getUid(), source.getFirstName(), source.getLastName());
    }
}
