package igti.pa.multitenancy.domain.vo;

import java.util.List;

public interface IService<T> {

    List<T> findAll();

    T findById(Integer id);

    T save(T t);

    T update(T t);

    void delete(Integer id);
}
