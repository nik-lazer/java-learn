package lan.training.advanced.parser;

import lan.training.advanced.resource.Resource;

/**
 * Parser interface for using in {@link lan.training.advanced.resource.ResourceFactory}
 * @author nik-lazer  14.01.2015   14:00
 */
public interface ResourceParser {
	Resource parse(String fileName);
}
