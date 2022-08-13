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
    }

    private void deleteCustomerController() {

    }

    private void updateCustomerController() {

    }

    private void printAllCustomerController() {

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
