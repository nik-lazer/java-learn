package lan.training.core.factory;

import lan.training.core.model.Publisher;

/**
 * Created by nik-lazer on 2/15/2016.
 */
public interface PublisherFactory {
    Publisher of(Integer uid, String name, String address);
}
