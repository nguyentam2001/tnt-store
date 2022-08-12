package service.impl;

import dao.AddressDAO;
import dao.impl.AddressDAOImpl;
import model.Address;
import service.AddressService;
import util.Validator;

import java.util.List;

public class AddressServiceImpl implements AddressService {
    private AddressDAO addressDAO;
    public  AddressServiceImpl(){
        addressDAO= new AddressDAOImpl();
    }
    @Override
    public boolean save(Address address) {
        if(Validator.getInstance().checkEmpty(address.getDistrict()))
        return false;
        else
        return addressDAO.save(address)>0;
    }

    @Override
    public boolean delete(int id) {
        return addressDAO.delete(id)>0;
    }

    @Override
    public List<Address> findAll() {
        return addressDAO.findAll();
    }

    @Override
    public boolean update(int id, Address address) {
        Address currAddress= addressDAO.getAddressById(id);
        if(currAddress!=null){
            return  addressDAO.update(id,address)>0;
        }
        return false;
    }
}
