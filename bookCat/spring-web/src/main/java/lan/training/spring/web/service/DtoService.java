package lan.training.spring.web.service;

import lan.training.spring.web.dto.AbstractDto;

import java.util.List;

/**
 * Created by nik-lazer on 2/16/2016.
 */
public interface DtoService<T extends AbstractDto> {
    List<T> getList();
    T getById(Integer id);
    void add(T dto);
    void update(T dto);
    void delete(T dto);
}
