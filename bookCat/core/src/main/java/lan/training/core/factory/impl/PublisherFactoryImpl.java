package lan.training.core.factory.impl;

import lan.training.core.factory.PublisherFactory;
import lan.training.core.model.Publisher;
import org.springframework.stereotype.Component;

/**
 * Created by nik-lazer on 2/15/2016.
 */
@Component
public class PublisherFactoryImpl implements PublisherFactory {
    @Override
    public Publisher of(Integer uid, String name, String address) {
        return new Publisher(uid, name, address);
    }
}
