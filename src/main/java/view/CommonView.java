package view;

import java.util.Locale;
import java.util.Scanner;

public class CommonView {
    private static CommonView instance;
    private Scanner scanner;


    CommonView() {
        scanner = new Scanner(System.in);
    }

    public static CommonView getInstance() {
        return instance = instance == null ? new CommonView() : instance;
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void mainMenu() {
        System.out.println("==================WELCOME TO TNT STORE================");
        System.out.println("1. Order product ");
        System.out.println("2. Login width admin ");
        System.out.println("======================================================");
    }

    public void printSubMenu(String name) {
        System.out.println("\t============== "+name.toUpperCase()+" ============");
        System.out.println("\t1. Create new "+name);
        System.out.println("\t2. Print all "+name);
        System.out.println("\t3. Update "+name);
        System.out.println("\t4. delete "+name);
        System.out.println("\t0. Exit to main menu");
        System.out.println("\t===================================");
    }

    public int inputId(String name) {
        System.out.print("Enter " + name + " id: ");
        if(scanner.hasNextInt()){
            int id = scanner.nextInt();
            scanner.nextLine();
            return id;
        }
       return  inputId(name);
    }


    public void customerMenu() {
        System.out.println("===================TNT STORE===============");
        System.out.println("1: Order product");
        System.out.println("2: Check receipt");
        System.out.println("0: Exist");
        System.out.println("===========================================");
    }

    public void managementMenuMenu() {
        System.out.println("==========================TNT STORE===================");
        System.out.println("1. Address management ");
        System.out.println("2. Customer management ");
        System.out.println("3. Discount management ");
        System.out.println("4. Order management ");
        System.out.println("5. Order detail management ");
        System.out.println("6. Product management ");
        System.out.println("0. Exit");
        System.out.println("======================================================");
    }
}
