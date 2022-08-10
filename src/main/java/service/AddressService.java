package service;

import model.Address;

public interface AddressService {
    boolean save(Address address);
    int add(Address address);
    int test();
}
