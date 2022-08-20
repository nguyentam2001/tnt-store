package view;

import model.Address;
import util.Validator;

import java.util.List;
import java.util.Scanner;

public class AddressView {
    private final static Scanner scanner = new Scanner(System.in);
    private final static Address address = new Address();

    public static Address inputAddress() {
        System.out.print("\tEnter city: ");
        address.setCity(scanner.nextLine());
        System.out.print("\tEnter district: ");
        address.setDistrict(scanner.nextLine());
        System.out.print("\tEnter sub district: ");
        address.setSubDistrict(scanner.nextLine());
        System.out.print("\tEnter postal code: ");
        address.setPostalCode(scanner.nextLine());
        address.setDeliveryFree(Validator.getInstance().moneyValidate(" delivery free"));
        return address;
    }

    public static void printAddress(List<Address> addresses) {
        System.out.println("\tChose address");
        CommonView.getInstance().printLineLimit(70);
        CommonView.getInstance().printTitleLimit("ADDRESS_ID", "CITY", "DELIVERY_FEE");
        for (Address address :
                addresses) {
            CommonView.getInstance().printLimit(address.getAddressId(), address.getCity(), address.getDeliveryFree());
        }
        CommonView.getInstance().printLineLimit(70);
    }

}
