package service;

import model.Product;

public interface ProductService extends CommonService<Product>{
    Product getProductById(int id);
}
