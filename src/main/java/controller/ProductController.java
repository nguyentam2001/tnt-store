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

    ProductController() {
        productService = new ProductServiceImpl();
    }

    private static ProductController instance;

    public static ProductController getInstance() {
        return instance = instance == null ? new ProductController() : instance;
    }

    public void productMenuController() {
        int pick;
        do {
            CommonView.getInstance().printSubMenu(Resources.PRODUCT_TITLE);
            pick = Main.scanner.nextInt();
            switch (pick) {
                case 1:
                    saveProductController();
                    break;
                case 2:
                    printProducts();
                    break;
                case 3:
                    updateProductController();
                    break;
                case 4:
                    deleteProductController();
                    break;
                default:
                    break;
            }

        } while (pick != 0);
    }

    private void deleteProductController() {
        int id = CommonView.getInstance().inputId(Resources.PRODUCT_TITLE);
        Product product = productService.getProductById(id);
        if (product != null) {
            productService.delete(id);
            CommonView.getInstance().displayMessage(Resources.DELETE_SUCCESS_MSG);
        } else {
            CommonView.getInstance().displayMessage(Resources.DELETE_FAIL_MSG);
        }
    }


    public void updateProductController() {
        boolean isCon;
        do {
            int id = CommonView.getInstance().inputId(Resources.PRODUCT_TITLE);
            Product product = productService.getProductById(id);
            if (product != null) {
                product = ProductView.getInstance().inputProduct();
                boolean result = productService.update(id, product);
                if (result) {
                    CommonView.getInstance().displayMessage(Resources.UPDATE_SUCCESS_MSG);
                } else {
                    CommonView.getInstance().displayMessage(Resources.UPDATE_FAIL_MSG);
                }
            }
            isCon = Main.isContinue();
        } while (isCon);
    }

    public void printProducts() {
        ProductView.getInstance().printLine();
        ProductView.getInstance().productTitle();
        ProductView.getInstance().printLine();
        List<Product> products = productService.findAll();
        products.forEach(System.out::println);
        ProductView.getInstance().printLine();
    }

    public void saveProductController() {
        boolean isCon;
        do {
            Product product = ProductView.getInstance().inputProduct();
            if (productService.save(product)) {
                CommonView.getInstance().displayMessage(Resources.ADD_SUCCESS_MSG);
            } else {
                CommonView.getInstance().displayMessage(Resources.ADD_FAIL_MSG);
            }
            isCon = Main.isContinue();
        } while (isCon);

    }
}
