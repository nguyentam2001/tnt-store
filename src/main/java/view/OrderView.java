package view.order;

import model.Address;
import model.Order;

import java.time.LocalDate;
import java.util.Scanner;

public class OrderView {
    private static Scanner scanner=new Scanner(System.in);;
    private static Order order= new Order();;

    public static Order inputOrder() {
        System.out.print("\tEnter name: ");
        String name = scanner.nextLine();
        order.setName(name);
        System.out.print("\tEnter phone number: ");
        String phoneNumber = scanner.nextLine();
        order.setPhoneNumber(phoneNumber);
        System.out.print("\tEnter detail address: ");
        String detailAddress = scanner.nextLine();
        order.setDetailAddress(detailAddress);
        System.out.print("\tEnter total: ");
        int total = scanner.nextInt();
        order.setTotal(total);
        System.out.print("\tEnter local date: ");
        LocalDate date = LocalDate.parse(scanner.nextLine());
        order.setOrderDate(date);
        System.out.print("\tEnter customerID: ");
        int customerID = scanner.nextInt();
        order.setCustomerId(customerID);
        System.out.print("\tEnter addressID: ");
        int addressID = scanner.nextInt();
        order.setAddressId(addressID);
        System.out.print("\tEnter discountID: ");
        int discountID = scanner.nextInt();
        order.setDiscountId(discountID);
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
        System.out.printf("| %10s | %15s | %15s | %15s | %15s | %15s | %15s| %15s | %15s |\n", "ORDER_ID", "NAME",
                "PHONE_NUMBER", "DETAIL_ADDRESS", "TOTAL", "ORDER_DATE", "CUSTOMER_ID", "DISCOUNT_ID","ADDRESS_ID");
        printLineOrder();
    }

    public  static  void  printLineOrder(){
        System.out.println("--------------------------------------------------------------------" +
                "------------------------------------");
    }


    public static void printOrder(Order order) {
        System.out.printf("| %10d | %15s | %15s | %15s | %15s | %15s | %15s | %15s | %15d |\n", order.getOrderId(),order.getName(),order.getPhoneNumber()
        ,order.getOrderDate(),order.getTotal(),order.getDetailAddress(),order.getCustomerId(),
                order.getAddressId(),order.getDiscountId());
    }

}
