package controller;

import model.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;
import util.Resources;
import view.CommonView;
import view.ProductView;

import java.util.List;

public class ProductController {
    private ProductService productService;
    ProductController(){
        productService= new ProductServiceImpl();
    }
    private static ProductController instance;

    public static ProductController getInstance() {
        return instance=instance==null?new ProductController():instance;
    }

    public  void  productMenuController(){
        int pick=0;
        do {
            CommonView.getInstance().printSubMenu("product");
            pick=Main.scanner.nextInt();
            switch (pick){
                case 1:saveProductController(); break;
                case 2:printProducts(); break;
                default: break;
            }

        }while (pick!=0);
    }

    public void  printProducts(){
        ProductView.getInstance().printLine();
        ProductView.getInstance().productTitle();
        ProductView.getInstance().printLine();
        List<Product> products= productService.findAll();
        products.forEach(System.out::println);
        ProductView.getInstance().printLine();
    }
    public  void  saveProductController(){
       Product product = ProductView.getInstance().inputProduct();
       if( productService.save(product)){
           CommonView.getInstance().displayMessage(Resources.ADD_SUCCESS_MSG);
       }else {
           CommonView.getInstance().displayMessage(Resources.ADD_FAIL_MSG);
       }
    }
}
