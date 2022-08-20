package dao.impl;

import dao.ProductDAO;
import model.Product;
import util.DBUtil;
import util.Resources;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    @Override
    public int save(Product product) {
        try (Connection connection = DBUtil.getInstance().getConnection()) {
            String sql = Resources.INSERT_PRODUCT;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement = DBUtil.getInstance().statementBinding(preparedStatement, product.getName(), product.getDescription(),
                    product.getPrice(), product.getDiscountPrice(), product.getStock(), product.getSold(), product.getDate(), product.getStatus());
            if (preparedStatement != null) {
                return preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int id) {
        try (Connection connection = DBUtil.getInstance().getConnection()
        ) {
            String sql = Resources.DELETE_PRODUCT + id;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public List<Product> findAll() {
        try (Connection connection = DBUtil.getInstance().getConnection();
             Statement statement = connection.createStatement()) {
            String sql = Resources.SELECT_PRODUCT;
            ResultSet resultSet = statement.executeQuery(sql);
            List<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                Product product = (Product) DBUtil.getInstance().columnBinding(new Product(), resultSet);
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product getById(int id) {
        try (Connection connection = DBUtil.getInstance().getConnection();
             Statement statement = connection.createStatement()) {
            String sql = Resources.SELECT_PRODUCT_BY_ID + id;
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return (Product) DBUtil.getInstance().columnBinding(new Product(), resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int update(int id, Product product) {
        try (Connection connection = DBUtil.getInstance().getConnection()) {
            String sql = Resources.UPDATE_PRODUCT;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement = DBUtil.getInstance().statementBinding(preparedStatement, product.getName(), product.getDescription(),
                    product.getPrice(), product.getDiscountPrice(), product.getStock(), product.getSold(), product.getDate(), product.getStatus(),
                    id);
            if (preparedStatement != null) {
                return preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
