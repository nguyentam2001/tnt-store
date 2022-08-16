package view;
import model.Address;
import model.Customer;
import util.Validator;
import java.util.List;
import java.util.Scanner;

public class CustomerView {
    private static   CustomerView instance;
    private    Customer customer;
    private  Scanner scanner;
    public  CustomerView(){
        customer= new Customer();
        scanner= new Scanner(System.in);
    }
    public  static CustomerView getInstance(){
        return  instance=instance==null?new CustomerView():instance;
    }

    public  Customer inputCustomer(List<Address> addresses) {
        System.out.print("\tEnter full name: ");
        customer.setFullName(scanner.nextLine());
        customer.setPhoneNumber(Validator.getInstance().phoneValidate());
        customer.setEmail(Validator.getInstance().emailValidate());
        System.out.println("\tChoose id address");
        AddressView.printAddress(addresses);
        System.out.print("\tEnter address id: ");
        customer.setAddressId(scanner.nextInt());
        scanner.nextLine();
        return  customer;
    }

    public void titleCustomer() {
        printLineCustomer();
        System.out.printf("| %10s | %20s | %20s | %20s | %20s |\n", "CUSTOMER_ID", "CUSTOMER_NAME",
                "EMAIL", "PHONE_NUMBER", "CITY_ADDRESS");
        printLineCustomer();
    }

    public   void  printLineCustomer(){
        System.out.println("--------------------------------------------------------------------" +
                "---------------------------------------");
    }


    public void printCustomer(Customer customer,Address address) {
        System.out.printf("| %10d  | %20s | %20s | %20s | %20s |\n", customer.getCustomerId(), customer.getFullName(), customer.getEmail(),customer.getPhoneNumber(),address.getCity());
    }
}
