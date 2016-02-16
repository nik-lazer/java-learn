package lan.training.spring.web.service.impl;

import lan.training.core.model.Author;
import lan.training.service.AuthorService;
import lan.training.spring.web.dto.AbstractDto;
import lan.training.spring.web.dto.AuthorDto;
import lan.training.spring.web.service.AuthorDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nik-lazer on 2/16/2016.
 */
@Service
public class AuthorDtoServiceImpl implements AuthorDtoService {
    @Autowired
    AuthorService authorService;
    @Autowired
    ConversionServiceFactoryBean conversionService;

    @Override
    public List<AuthorDto> getList() {
        List<Author> authorList = authorService.getList();
        List<AuthorDto> authorDtoList = new ArrayList<>();
        for (Author author: authorList) {
            authorDtoList.add(conversionService.getObject().convert(author, AuthorDto.class));
        }
        return authorDtoList;
    }

    @Override
    public AuthorDto getById(Integer id) {
        Author author = authorService.getById(id);
        return conversionService.getObject().convert(author, AuthorDto.class);
    }

    @Override
    public void add(AuthorDto dto) {
        authorService.add(conversionService.getObject().convert(dto, Author.class));
    }

    @Override
    public void update(AuthorDto dto) {
        authorService.update(conversionService.getObject().convert(dto, Author.class));
    }

    @Override
    public void delete(AuthorDto dto) {
        authorService.delete(conversionService.getObject().convert(dto, Author.class));
    }
}
