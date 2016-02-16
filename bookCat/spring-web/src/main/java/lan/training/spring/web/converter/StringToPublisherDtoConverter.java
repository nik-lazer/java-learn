package lan.training.spring.web.converter;

import lan.training.core.model.Publisher;
import lan.training.service.PublisherService;
import lan.training.spring.web.dto.PublisherDto;
import lan.training.spring.web.service.PublisherDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;


/**
 * String to {@link lan.training.core.model.Publisher} converter for forms
 * @author nik-lazer  10.12.2014   15:07
 */
public class StringToPublisherDtoConverter implements Converter<String, PublisherDto> {

	@Autowired
	PublisherDtoService publisherService;

	@Override
	public PublisherDto convert(String source) {
		int uuid = Integer.valueOf(source);
		PublisherDto publisher = publisherService.getById(uuid);
		return publisher;
	}
}
