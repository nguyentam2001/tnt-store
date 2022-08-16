package dao;

import model.Customer;

public interface CustomerDAO extends CommonDAO<Customer> {
    Customer getCustomerByPhone(String phone);
}
