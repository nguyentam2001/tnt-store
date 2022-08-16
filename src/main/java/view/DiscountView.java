package view.discount;

import model.Discount;

import java.time.LocalDate;
import java.util.Scanner;

public class DiscountView {
    private static Scanner scanner=new Scanner(System.in);;
    private static Discount discount= new Discount();;

    public static Discount inputDiscount() {
        System.out.print("\tEnter discount ID: ");
        int discount_id = scanner.nextInt();
        discount.setDiscountId(discount_id);
        System.out.print("\tEnter title: ");
        String title = scanner.nextLine();
        discount.setTitle(title);
        System.out.print("\tEnter type: ");
        String type = scanner.nextLine();
        discount.setType(type);
        System.out.print("\tEnter discountPrice: ");
        Double discountPrice = scanner.nextDouble();
        discount.setDiscountPrice(discountPrice);
        System.out.print("\tEnter start date: ");
        LocalDate startDate = LocalDate.parse(scanner.nextLine());
        discount.setStartDate(startDate);
        System.out.print("\tEnter end date: ");
        LocalDate endDate = LocalDate.parse(scanner.nextLine());
        discount.setEndDate(endDate);
        return discount;
    }

    public static void printViewDiscount() {
        System.out.println("\t============== Discount ============");
        System.out.println("\t1. Create new discount");
        System.out.println("\t2. Print discount");
        System.out.println("\t3. Update discount");
        System.out.println("\t4. delete discount");
        System.out.println("\t0. Exit to main menu");
        System.out.println("\t===================================");
    }

    public static void titleDiscount() {
        printLineDiscount();
        System.out.printf("| %10s | %15s | %15s | %15s | %15s | %15s |\n", "DISCOUNT_ID", "TITLE",
                "TYPE", "DISCOUNT_PRICE", "START_DATE", "END_DATE");
        printLineDiscount();
    }

    public  static  void  printLineDiscount(){
        System.out.println("--------------------------------------------------------------------" +
                "------------------------------------");
    }


    public static void printDiscount(Discount discount) {

        System.out.printf("| %10d | %15s | %15s | %15s | %15s | %15d |\n", discount.getDiscountId(),
                discount.getTitle(),discount.getType(),discount.getDiscountPrice()
                ,discount.getStartDate(),discount.getEndDate());
    }


}
