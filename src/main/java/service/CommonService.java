package service;

import model.Address;

import java.util.List;

public interface CommonService<E> {
    boolean save(E e);

    boolean delete(int id);

    List<E> findAll();

    boolean update(int id, E e);
}
