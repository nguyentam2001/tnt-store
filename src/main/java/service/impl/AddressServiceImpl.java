package service.impl;

import dao.AddressDAO;
import dao.impl.AddressDAOImpl;
import model.Address;
import service.AddressService;
import util.Resources;
import util.Validator;
import view.CommonView;

import java.util.List;

public class AddressServiceImpl implements AddressService {
    private AddressDAO addressDAO;

    public AddressServiceImpl() {
        addressDAO = new AddressDAOImpl();
    }

    @Override
    public boolean save(Address address) {
        if (Validator.getInstance().checkEmpty(address.getDistrict()))
            return false;
        else
            return addressDAO.save(address) > 0;
    }

    @Override
    public boolean delete(int id) {
        Address address = addressDAO.getById(id);
        if (address != null) {
            return addressDAO.delete(id) > 0;
        } else {
            CommonView.getInstance().displayMessage(Resources.ADDRESS_NOT_EXIST + id);
        }
        return false;
    }

    @Override
    public List<Address> findAll() {
        return addressDAO.findAll();
    }

    @Override
    public boolean update(int id, Address address) {
        Address currAddress = addressDAO.getById(id);
        if (currAddress != null) {
            return addressDAO.update(id, address) > 0;
        } else {
            CommonView.getInstance().displayMessage(Resources.ADDRESS_NOT_EXIST + id);
        }
        return false;
    }
    public  Address getAddressById(int id){
        return  addressDAO.getById(id);
    }
}
