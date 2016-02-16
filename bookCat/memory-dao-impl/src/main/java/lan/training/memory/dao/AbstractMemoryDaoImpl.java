package lan.training.memory.dao;

import lan.training.core.dao.CrudDao;
import lan.training.core.model.IEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Abstract service for in-memory data storing
 * @author nik-lazer  10.12.2014   13:25
 */
public abstract class AbstractMemoryDaoImpl<T extends IEntity> implements CrudDao<T> {
	private Map<Integer, T> data;

	public Map<Integer, T> listToMap(List<T> list) {
		Map<Integer, T> map = new HashMap<>();
		for (T domain: list) {
			map.put(domain.getUid(), domain);
		}
		return map;
	}

	protected Map<Integer, T> getData() {
		return data;
	}

	protected void setData(Map<Integer, T> data) {
		this.data = data;
	}

	@Override
	public List<T> getList() {
		return new ArrayList<T>(data.values());
	}

	@Override
	public void add(T model) {
		data.put(model.getUid(), model);
	}

	@Override
	public void update(Integer id, T model) {
		data.put(model.getUid(), model);
	}

	@Override
	public void delete(Integer id) {
		data.remove(id);
	}

	@Override
	public T getById(Integer id) {
		return data.get(id);
	}

}
