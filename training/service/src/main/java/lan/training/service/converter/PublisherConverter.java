package lan.training.service.converter;

import lan.training.core.model.Publisher;
import lan.training.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.util.UUID;

/**
 * String to {@link lan.training.core.model.Publisher} converter for forms
 * @author nik-lazer  10.12.2014   15:07
 */
public class PublisherConverter implements Converter<String, Publisher> {

	@Autowired
	PublisherService publisherService;

	@Override
	public Publisher convert(String source) {
		UUID uuid = UUID.fromString(source);
		Publisher publisher = publisherService.getById(uuid);
		return publisher;
	}
}
