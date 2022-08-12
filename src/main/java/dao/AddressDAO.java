package dao;

import model.Address;

import java.util.List;

public interface AddressDAO {
    int save(Address address);

    int delete(int id);

    List<Address> findAll();

    Address getAddressById(int id);

    int update(int id, Address address);
}
