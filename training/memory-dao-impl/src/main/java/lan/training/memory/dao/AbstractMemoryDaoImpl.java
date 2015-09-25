package lan.training.memory.dao;

import lan.training.core.dao.CrudDao;
import lan.training.core.model.IEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Abstract service for in-memory data storing
 * @author nik-lazer  10.12.2014   13:25
 */
public abstract class AbstractMemoryDaoImpl<T extends IEntity> implements CrudDao<T> {
	private Map<UUID, T> data;

	public Map<UUID, T> listToMap(List<T> list) {
		Map<UUID, T> map = new HashMap<>();
		for (T domain: list) {
			if (domain.getUid() == null) {
				domain.setUid(UUID.randomUUID());
			}
			map.put(domain.getUid(), domain);
		}
		return map;
	}

	protected Map<UUID, T> getData() {
		return data;
	}

	protected void setData(Map<UUID, T> data) {
		this.data = data;
	}

	@Override
	public List<T> getList() {
		return new ArrayList<T>(data.values());
	}

	@Override
	public void add(T model) {
		if (model.getUid() == null) {
			model.setUid(UUID.randomUUID());
		}
		data.put(model.getUid(), model);
	}

	@Override
	public void update(UUID id, T model) {
		data.put(model.getUid(), model);
	}

	@Override
	public void delete(UUID id) {
		data.remove(id);
	}

	@Override
	public T getById(UUID id) {
		return data.get(id);
	}

}
