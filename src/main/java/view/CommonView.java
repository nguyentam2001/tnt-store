package view;

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

    public int inputId(String name) {
        System.out.print("Enter " + name + " id: ");
        if(scanner.hasNextInt()){
            int id = scanner.nextInt();
            scanner.nextLine();
            return id;
        }
       return  inputId(name);
    }
}
