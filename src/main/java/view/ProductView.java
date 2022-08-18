package view;



import model.Discount;
import model.Product;
import util.Validator;

import java.util.Scanner;

public class ProductView {

    private static   ProductView instance;
    private Scanner scanner;
    public  ProductView(){
        scanner= new Scanner(System.in);
    }
    public  static ProductView getInstance(){
        return  instance=instance==null?new ProductView():instance;
    }
    public  void  productTitle(){
        System.out.printf("| %10s | %15s | %15s | %15s | %15s | %15s | %15s |\n",
                "PRODUCT_ID","[NAME]","PRICE","DISCOUNT_PRICE","SOLD","STOCK","[STATUS]");
    }
    public  void  printLine(){
        System.out.println("-------------------------------------------------------" +
                "--------------------------------------------------------------------");
    }

    public  Product inputProduct() {
        Product product= new Product();
        System.out.print("Enter name: ");
        product.setName(scanner.nextLine());
        System.out.print("Enter description: ");
        product.setDescription(scanner.nextLine());
        System.out.print("Enter price: ");
        product.setPrice(scanner.nextLong());
        scanner.nextLine();
        System.out.print("Enter discount price: ");
        product.setDiscountPrice(scanner.nextDouble());
        scanner.nextLine();
        System.out.print("Enter stock: ");
        product.setStock(scanner.nextDouble());
        System.out.print("Enter sold: ");
        product.setSold(scanner.nextInt());
        product.setDate(Validator.getInstance().currDate());
        System.out.println("Enter status 0-1: ");
        product.setStatus(scanner.nextInt());
        scanner.nextLine();
        return product;
    }

}
