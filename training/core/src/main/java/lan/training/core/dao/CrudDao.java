package lan.training.core.dao;

import lan.training.core.model.Entity;

import java.util.List;
import java.util.UUID;

/**
 * CRUD interface
 * @author nik-lazer  09.12.2014   19:21
 */
public interface CrudDao<T extends Entity> {
	List<T> getList();
	void add(T model);
	void update(UUID id, T model);
	void delete(UUID id);
	T getById(UUID id);
}
