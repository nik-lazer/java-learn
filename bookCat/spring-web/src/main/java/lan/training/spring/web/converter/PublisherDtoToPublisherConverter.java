package lan.training.spring.web.converter;

import lan.training.core.factory.PublisherFactory;
import lan.training.core.model.Publisher;
import lan.training.spring.web.dto.PublisherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by nik-lazer on 2/16/2016.
 */
public class PublisherDtoToPublisherConverter implements Converter<PublisherDto, Publisher> {
    @Autowired
    PublisherFactory publisherFactory;
    @Override
    public Publisher convert(PublisherDto source) {
        return publisherFactory.of(source.getUid(), source.getName(), source.getAddress());
    }
}
