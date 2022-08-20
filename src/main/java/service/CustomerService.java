package service;

import model.Customer;


public interface CustomerService extends CommonService<Customer> {
    Customer getCustomerById(int id);

    Customer getCustomerByPhone(String phone);

    int getCustomerIdSave(Customer customer);
}
