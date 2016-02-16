package lan.training.spring.web.service.impl;

import lan.training.core.model.Publisher;
import lan.training.service.PublisherService;
import lan.training.spring.web.dto.PublisherDto;
import lan.training.spring.web.service.PublisherDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nik-lazer on 2/16/2016.
 */
@Service
public class PublisherDtoServiceImpl implements PublisherDtoService {
    @Autowired
    PublisherService publisherService;
    @Autowired
    ConversionServiceFactoryBean conversionService;

    @Override
    public List<PublisherDto> getList() {
        List<Publisher> publisherList = publisherService.getList();
        List<PublisherDto> publisherDtoList = new ArrayList<>();
        for (Publisher publisher: publisherList) {
            publisherDtoList.add(conversionService.getObject().convert(publisher, PublisherDto.class));
        }
        return publisherDtoList;
    }

    @Override
    public PublisherDto getById(Integer id) {
        Publisher publisher = publisherService.getById(id);
        return conversionService.getObject().convert(publisher, PublisherDto.class);
    }

    @Override
    public void add(PublisherDto dto) {
        publisherService.add(conversionService.getObject().convert(dto, Publisher.class));
    }

    @Override
    public void update(PublisherDto dto) {
        publisherService.update(conversionService.getObject().convert(dto, Publisher.class));
    }

    @Override
    public void delete(PublisherDto dto) {
        publisherService.delete(conversionService.getObject().convert(dto, Publisher.class));
    }
}
