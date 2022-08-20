
package view;

import model.Discount;
import util.Validator;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class DiscountView {
    private static Scanner scanner = new Scanner(System.in);
    private static Discount discount = new Discount();
    ;

    public static Discount inputDiscount() {
        System.out.print("\tEnter title: ");
        discount.setTitle(scanner.nextLine());
        System.out.print("\tEnter type: ");
        discount.setType(scanner.nextLine());
        System.out.print("\tEnter discountPrice: ");
        discount.setDiscountPrice(scanner.nextDouble());
        scanner.nextLine();
        System.out.print("\tEnter start date: ");
        discount.setStartDate(Validator.getInstance().inputDate());
        System.out.print("\tEnter end date: ");
        discount.setEndDate(Validator.getInstance().inputDate());
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

    public static void printLineDiscount() {
        System.out.println("--------------------------------------------------------------------" +
                "------------------------------------");
    }


    public static void printDiscount(Discount discount) {

        System.out.printf("| %10d  | %15s | %15s | %15s | %15s | %15s |\n", discount.getDiscountId(),
                discount.getTitle(), discount.getType(), discount.getDiscountPrice()
                , discount.getStartDate(), discount.getEndDate());
    }


}
