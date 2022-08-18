
package view;

import controller.CustomerOrderController;
import controller.DiscountController;
import model.Address;
import model.Discount;
import model.Order;
import util.Validator;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class OrderView {
    private static Scanner scanner=new Scanner(System.in);;
    private static Order order= new Order();;

    public static Order inputOrder(List<Address> addresses) {

        System.out.print("\tEnter order name: ");
        order.setName(scanner.nextLine());
        System.out.print("\tEnter phone number: ");
        order.setPhoneNumber(scanner.nextLine());
        System.out.println("\tChoose id address");
        AddressView.printAddress(addresses);
        System.out.print("\tEnter addressID: ");
        order.setAddressId(scanner.nextInt());
        scanner.nextLine();
        System.out.print("\tEnter detail address: ");
        order.setDetailAddress(scanner.nextLine());
        System.out.print("\tEnter total: ");
        order.setTotal( scanner.nextInt());
        order.setOrderDate(Validator.getInstance().currDate());
        System.out.print("\tEnter customerID: ");
        order.setCustomerId(scanner.nextInt());
        scanner.nextLine();
        System.out.print("\tEnter discountID: ");
        DiscountController.getInstance().printAllDiscountController();
        order.setDiscountId(scanner.nextInt());
        scanner.nextLine();
        return order;
    }

    public static void printViewOrder() {
        System.out.println("\t============== Order ============");
        System.out.println("\t1. Create new Order");
        System.out.println("\t2. Print Order");
        System.out.println("\t3. Update Order");
        System.out.println("\t4. delete Order");
        System.out.println("\t0. Exit to main menu");
        System.out.println("\t===================================");
    }

    public static void titleOrder() {
        printLineOrder();
        System.out.printf("| %10s | %15s | %15s | %15s | %15s | %35s | %15s | %15s | %15s |\n", "ORDER_ID", "NAME",
                "PHONE_NUMBER","ORDER_DATE",  "TOTAL", "DETAIL_ADDRESS", "CUSTOMER_ID", "DISCOUNT_ID","ADDRESS_ID");
        printLineOrder();
    }


    public  static  void  printLineOrder(){
        System.out.println("--------------------------------------------------------------------" +
                "------------------------------------" +
                "------------------------------------" +
                "-------------------" +
                "-------------------");
    }


    public static void printOrder(Order order) {
        System.out.printf("| %10s | %15s | %15s | %15s | %15s | %35s | %15s | %15s | %15s |\n", order.getOrderId()
                ,order.getName(),order.getPhoneNumber()
        ,order.getOrderDate(),order.getTotal(),order.getDetailAddress(),order.getCustomerId(),
                order.getAddressId(),order.getDiscountId());
    }


}
