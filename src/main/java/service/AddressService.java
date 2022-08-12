package service;

import model.Address;

import java.util.List;

public interface AddressService {
    boolean save(Address address);

    boolean delete(int id);

    List<Address> findAll();

    boolean update(int id, Address address);
}
