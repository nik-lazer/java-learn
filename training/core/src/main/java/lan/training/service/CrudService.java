package lan.training.service;

import java.util.List;
import java.util.UUID;

/**
 * CRUD interface
 * @author nik-lazer  09.12.2014   19:21
 */
public interface CrudService<T> {
	List<T> getList();
	void add(T model);
	void update(T model);
	void delete(T model);
	T getById(UUID id);
}
