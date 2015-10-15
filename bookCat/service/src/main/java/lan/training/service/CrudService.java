package lan.training.service;

import lan.training.core.model.IEntity;

import java.util.List;

/**
 * CRUD interface
 * @author nik-lazer  09.12.2014   19:21
 */
public interface CrudService<T extends IEntity> {
	List<T> getList();
	void add(T model);
	void update(T model);
	void delete(T model);
	T getById(int id);
}
