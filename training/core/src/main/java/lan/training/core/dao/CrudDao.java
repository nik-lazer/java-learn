package lan.training.core.dao;

import lan.training.core.model.IEntity;

import java.util.List;

/**
 * CRUD interface
 * @author nik-lazer  09.12.2014   19:21
 */
public interface CrudDao<T extends IEntity> {
	List<T> getList();
	void add(T model);
	void update(Integer id, T model);
	void delete(Integer id);
	T getById(Integer id);
}
