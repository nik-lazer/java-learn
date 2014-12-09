package lan.training.spring.service;

import java.util.List;

/**
 * CRUD interface
 * @author nik-lazer  09.12.2014   19:21
 */
public interface CRUDService<T> {
	List<T> getList();
	void add(T model);
	void update(int id, T model);
	void delete(T model);
	T getById(int id);
}
