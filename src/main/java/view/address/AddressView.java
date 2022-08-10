package view.address;

import model.Address;

import java.util.Scanner;

public class AddressView {
   private static Scanner scanner= new Scanner(System.in);
   private  static  Address address = new Address();
   public  static  Address  setAddress(){
       System.out.print("Enter city: ");
       String city=scanner.nextLine();
       address.setCity(city);
       System.out.print("Enter district: ");
       String district=scanner.nextLine();
       address.setDistrict(district);
       System.out.print("Enter sub district:");
       String subDistrict=scanner.nextLine();
       address.setSubDistrict(subDistrict);
       System.out.print("Enter postal code: ");
       String postalCode=scanner.nextLine();
       address.setPostalCode(postalCode);
       System.out.println("Enter delivery free");
       long  deliveryFree= scanner.nextLong();
       scanner.nextLine();
       address.setDeliveryFree(deliveryFree);
       return  address;
   }

}
