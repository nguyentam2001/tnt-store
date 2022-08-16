package controller;

import model.Address;
import model.Customer;
import service.AddressService;
import service.CustomerService;
import service.impl.AddressServiceImpl;
import service.impl.CustomerServiceImpl;
import util.Resources;
import view.CommonView;
import view.CustomerView;

import java.util.List;

public class CustomerController {
    private static   CustomerController instance;
    private CustomerService customerService;
    private AddressService addressService;
    public  CustomerController(){
        customerService= new CustomerServiceImpl();
        addressService= new AddressServiceImpl();
    }
    public  static  CustomerController getInstance(){
        return  instance=instance==null?new CustomerController():instance;

    }
    public  void  customerMenuController(){
        int pick=0;
        do {
            CommonView.getInstance().printSubMenu("customer");
            pick=Main.scanner.nextInt();
            switch (pick){
                case 1:saveCustomerController(); break;
                case 2:printAllCustomerController(); break;
                case 3:updateCustomerController();break;
                case 4:deleteCustomerController(); break;
                case 5:findCustomerByIdController();break;
                default: break;
            }

        }while (pick!=0);
    }

    private void findCustomerByIdController() {
        int id= CommonView.getInstance().inputId("customer");
        Customer customer= customerService.getCustomerById(id);
        if(customer!=null){
            CustomerView.getInstance().titleCustomer();
            Address address = addressService.getAddressById(customer.getAddressId());
            CustomerView.getInstance().printCustomer(customer,address);
        }
    }

    private void deleteCustomerController() {
        int id= CommonView.getInstance().inputId("customer");
        Customer customer= customerService.getCustomerById(id);
        if(customer!=null){
            customerService.delete(id);
            CommonView.getInstance().displayMessage(Resources.DELETE_SUCCESS_MSG);
        }
    }

    private void updateCustomerController() {
        int id= CommonView.getInstance().inputId("customer");
        Customer customer= customerService.getCustomerById(id);
        if(customer!=null){
            List<Address> addresses= addressService.findAll();
            customer=CustomerView.getInstance().inputCustomer(addresses);
            boolean result =customerService.update(id,customer);
            if(result){
                CommonView.getInstance().displayMessage(Resources.UPDATE_SUCCESS_MSG);
            }else {
                CommonView.getInstance().displayMessage(Resources.UPDATE_FAIL_MSG);
            }
        }
    }

    private void printAllCustomerController() {
        List<Customer> customers= customerService.findAll();
        CustomerView.getInstance().titleCustomer();
        for (Customer customer:
             customers) {
            Address address = addressService.getAddressById(customer.getAddressId());
            CustomerView.getInstance().printCustomer(customer,address);
        }
        CustomerView.getInstance().printLineCustomer();
    }

    private void saveCustomerController() {
        //get list address
        List<Address> addresses= addressService.findAll();
        Customer customer= CustomerView.getInstance().inputCustomer(addresses);
        boolean result = customerService.save(customer);
        if(result){
            CommonView.getInstance().displayMessage(Resources.ADD_SUCCESS_MSG);
        }else
            CommonView.getInstance().displayMessage(Resources.ADD_FAIL_MSG);
    }
}
