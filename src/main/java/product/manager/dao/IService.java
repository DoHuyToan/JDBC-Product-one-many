package product.manager.dao;

import java.util.List;

public interface IService <T>{
    List<T> findAll();
    boolean insert(T t);
    boolean update(T t);
    void delete(int id);
    T findById(int id);

}
