package service.impl;

import dao.ProductDAO;
import dao.impl.ProductDAOImpl;
import model.Product;
import service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductDAO productDAO;
    public ProductServiceImpl(){
        productDAO= new ProductDAOImpl();
    }
    @Override
    public boolean save(Product product) {

        return productDAO.save(product)>0;
    }

    @Override
    public boolean delete(int id) {
        return productDAO.delete(id)>0;
    }

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public boolean update(int id, Product product) {
        return productDAO.update(id,product)>0;
    }

    @Override
    public Product getProductById(int id) {
        return productDAO.getById(id);
    }
}
