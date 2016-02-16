package lan.training.spring.web.converter;

import lan.training.core.model.Publisher;
import lan.training.spring.web.dto.PublisherDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by nik-lazer on 2/15/2016.
 */
@Component
public class PublisherToDtoConverter implements Converter<Publisher, PublisherDto> {
    @Override
    public PublisherDto convert(Publisher source) {
        PublisherDto publisherDto = new PublisherDto();
        publisherDto.setUid(source.getUid());
        publisherDto.setName(source.getName());
        publisherDto.setAddress(source.getAddress());
        return publisherDto;
    }
}
