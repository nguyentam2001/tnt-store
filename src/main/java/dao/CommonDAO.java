package dao;

import java.util.List;

public interface CommonDAO<E> {
    int save(E e);

    int delete(int id);

    List<E> findAll();

    E getById(int id);

    int update(int id, E e);
}
