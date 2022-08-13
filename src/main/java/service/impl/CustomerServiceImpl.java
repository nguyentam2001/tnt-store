package service.impl;

import dao.CustomerDAO;
import dao.impl.CustomerDAOImpl;
import model.Customer;
import service.CustomerService;
import util.Resources;
import util.Validator;
import view.CommonView;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    CustomerDAO customerDAO;
    public CustomerServiceImpl(){
        customerDAO= new CustomerDAOImpl();
    }
    @Override
    public boolean save(Customer customer) {
        if(Validator.getInstance().checkEmpty(customer.getFullName())||
                Validator.getInstance().checkEmpty(customer.getPhoneNumber())){
            CommonView.getInstance().displayMessage(Resources.NAME_AND_PHONE_MSG);
            return  false;
        }else{
            if(isContain(findAll(),customer.getPhoneNumber())){
                CommonView.getInstance().displayMessage(Resources.PHONE_IS_EXIST);
                return false;
            }
            return customerDAO.save(customer)>0;
        }
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public boolean update(int id, Customer customer) {
        return false;
    }

    private  boolean isContain(List<Customer> customers, String phone){
        for (Customer cus:
             customers) {
            if(cus.getPhoneNumber().equals(phone))
                return  true;
        }
        return  false;
    }
}
