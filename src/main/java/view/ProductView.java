package view;



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
        System.out.print("\tEnter product name: ");
        product.setName(scanner.nextLine());
        System.out.print("\tEnter description: ");
        product.setDescription(scanner.nextLine());
        product.setPrice(Validator.getInstance().moneyValidate("price"));
        System.out.print("\tEnter discount price: ");
        product.setDiscountPrice(Validator.getInstance().inputDouble());
        System.out.print("\tEnter stock: ");
        product.setStock(Validator.getInstance().inputDouble());
        System.out.print("\tEnter sold: ");
        product.setSold(Validator.getInstance().inputInt());
        product.setDate(Validator.getInstance().currDate());
        System.out.print("\tEnter status 0-1: ");
        product.setStatus(Validator.getInstance().inputIntLimit01());
        return product;
    }

}
