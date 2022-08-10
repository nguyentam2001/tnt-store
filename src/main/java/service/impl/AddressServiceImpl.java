package service.impl;

import dao.AddressDAO;
import dao.impl.AddressDAOImpl;
import model.Address;
import service.AddressService;

public class AddressServiceImpl implements AddressService {
    private AddressDAO addressDAO;
    public  AddressServiceImpl(){
        addressDAO= new AddressDAOImpl();
    }
    @Override
    public boolean save(Address address) {
        if(address.getDistrict().trim().isEmpty())
        return false;
        else
        return addressDAO.save(address)>0;
    }

    @Override
    public int add(Address address) {
        return 0;
    }
}
