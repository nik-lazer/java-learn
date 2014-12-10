package lan.training.spring.service;

import java.util.List;
import java.util.UUID;

/**
 * CRUD interface
 * @author nik-lazer  09.12.2014   19:21
 */
public interface CRUDService<T> {
	List<T> getList();
	void add(T model);
	void update(UUID id, T model);
	void delete(UUID id);
	T getById(UUID id);
}
