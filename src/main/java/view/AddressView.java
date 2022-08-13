package view;

import model.Address;
import java.util.List;
import java.util.Scanner;

public class AddressView {
    private static Scanner scanner=new Scanner(System.in);;
    private static Address address= new Address();;

    public static Address inputAddress() {
        System.out.print("\tEnter city: ");
        String city = scanner.nextLine();
        address.setCity(city);
        System.out.print("\tEnter district: ");
        String district = scanner.nextLine();
        address.setDistrict(district);
        System.out.print("\tEnter sub district: ");
        String subDistrict = scanner.nextLine();
        address.setSubDistrict(subDistrict);
        System.out.print("\tEnter postal code: ");
        String postalCode = scanner.nextLine();
        address.setPostalCode(postalCode);
        System.out.print("\tEnter delivery free: ");
        long deliveryFree = scanner.nextLong();
        scanner.nextLine();
        address.setDeliveryFree(deliveryFree);
        return address;
    }



    public static void titleAddress() {
        printLineAddress();
        System.out.printf("| %10s | %15s | %15s | %15s | %15s | %15s |\n", "ADDRESS_ID", "CITY",
                "DISTRICT", "SUB_DISTRICT", "POSTAL_CODE", "DELIVERY_FEE");
        printLineAddress();
    }

    public  static  void  printLineAddress(){
        System.out.println("--------------------------------------------------------------------" +
                "------------------------------------");
    }


    public static void printAddress(Address address) {
        System.out.printf("| %10d | %15s | %15s | %15s | %15s | %15d |\n", address.getAddressId(), address.getCity(), address.getDistrict()
                , address.getSubDistrict(), address.getPostalCode(), address.getDeliveryFree());
    }

    public  static  void  printAddress(List<Address> addresses){
        System.out.println("===========Address==========");
        addresses.forEach(System.out::println);
        System.out.println("============================");
    }

}
