package lan.training.spring.service;

import lan.training.spring.model.AbstractDomain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Abstract service for in-memory data storing
 * @author nik-lazer  10.12.2014   13:25
 */
public class AbstractMemoryService<T extends AbstractDomain> {
	public Map<UUID, T> listToMap(List<T> list) {
		Map<UUID, T> map = new HashMap<>();
		for (T domain: list) {
			if (domain.getId() == null) {
				domain.setId(UUID.randomUUID());
			}
			map.put(domain.getId(), domain);
		}
		return map;
	}
}
