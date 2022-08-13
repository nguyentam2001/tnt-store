package service.impl;
import dao.AddressDAO;
import dao.CustomerDAO;
import dao.impl.AddressDAOImpl;
import dao.impl.CustomerDAOImpl;
import model.Customer;
import service.CustomerService;
import util.Resources;
import util.Validator;
import view.CommonView;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    CustomerDAO customerDAO;
    AddressDAO addressDAO;

    public CustomerServiceImpl() {
        customerDAO = new CustomerDAOImpl();
        addressDAO = new AddressDAOImpl();
    }

    @Override
    public boolean save(Customer customer) {
        if (Validator.getInstance().checkEmpty(customer.getFullName()) ||
                Validator.getInstance().checkEmpty(customer.getPhoneNumber())) {
            CommonView.getInstance().displayMessage(Resources.NAME_AND_PHONE_MSG);
            return false;
        } else {
            if (isContain(findAll(), customer.getPhoneNumber())) {
                CommonView.getInstance().displayMessage(Resources.PHONE_IS_EXIST);
                return false;
            }
            return customerDAO.save(customer) > 0;
        }
    }

    @Override
    public boolean delete(int id) {
        return customerDAO.delete(id) > 0;
    }

    @Override
    public List<Customer> findAll() {
        return customerDAO.findAll();
    }

    @Override
    public boolean update(int id, Customer customer) {
        return customerDAO.update(id, customer) > 0;
    }

    private boolean isContain(List<Customer> customers, String phone) {
        for (Customer cus :
                customers) {
            if (cus.getPhoneNumber().equals(phone))
                return true;
        }
        return false;
    }


    @Override
    public Customer getCustomerById(int id) {
        Customer customer= customerDAO.getById(id);
        if(customer==null){
            CommonView.getInstance().displayMessage(Resources.CUSTOMER_NOT_EXIST+id);
        }
        return  customer;
    }
}
