package view;

import model.Address;
import model.Customer;
import util.Validator;

import java.util.List;
import java.util.Scanner;

public class CustomerView {
    private static CustomerView instance;
    private Customer customer;
    private Scanner scanner;

    public CustomerView() {
        customer = new Customer();
        scanner = new Scanner(System.in);
    }

    public static CustomerView getInstance() {
        return instance = instance == null ? new CustomerView() : instance;
    }

    public Customer inputCustomer(List<Address> addresses) {
        System.out.print("\tEnter full name: ");
        customer.setFullName(scanner.nextLine());
        customer.setPhoneNumber(Validator.getInstance().phoneValidate());
        customer.setEmail(Validator.getInstance().emailValidate());
        System.out.println("\tChoose id address");
        AddressView.printAddress(addresses);
        System.out.print("\tEnter address id: ");
        customer.setAddressId(scanner.nextInt());
        scanner.nextLine();
        return customer;
    }
}
