package dao.impl;

import dao.OrderDAO;
import model.Order;
import util.DBUtil;
import util.Resources;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public int save(Order order) {
        try (Connection connection = DBUtil.getInstance().getConnection()) {
            String sql = Resources.INSERT_ORDER;
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement = DBUtil.getInstance().statementBinding(preparedStatement,
                    order.getName(), order.getPhoneNumber(), order.getDetailAddress(),
                    order.getTotal(), order.getOrderDate(), order.getCustomerId(),
                    order.getAddressId(), order.getDiscountId());
            preparedStatement.execute();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int id) {
        try (Connection connection = DBUtil.getInstance().getConnection()
        ) {
            String sql = Resources.DELETE_ORDER_BY_ID + id;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Order> findAll() {
        try (Connection connection = DBUtil.getInstance().getConnection()) {
            String sql = Resources.SELECT_ALL_ORDER;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Order> orders = new ArrayList<>();
            while (resultSet.next()) {
                Order order = (Order) DBUtil.getInstance().columnBinding(new Order(), resultSet);
                orders.add(order);
            }
            return orders;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Order getById(int id) {
        try (Connection connection = DBUtil.getInstance().getConnection();
             Statement statement = connection.createStatement()
        ) {
            String sql_select = Resources.SELECT_ORDER_BY_ID + id;
            ResultSet resultSet = statement.executeQuery(sql_select);
            Order order;
            if (resultSet.next()) {
                order = (Order) DBUtil.getInstance().columnBinding(new Order(), resultSet);
                return order;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int update(int id, Order order) {
        try (Connection connection = DBUtil.getInstance().getConnection()
        ) {
            String sql = Resources.UPDATE_ORDER;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement = DBUtil.getInstance().statementBinding(preparedStatement,
                    order.getName(), order.getPhoneNumber(), order.getDetailAddress(),
                    order.getTotal(), order.getOrderDate(), order.getCustomerId(),
                    order.getDiscountId(), order.getAddressId(), id);
            if (preparedStatement != null) {
                return preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Order> getOrderByPhone(String phone) {
        try (Connection connection = DBUtil.getInstance().getConnection()) {
            String sql = Resources.SELECT_ALL_ORDER_BY_PHONE + phone;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Order> orders = new ArrayList<>();
            while (resultSet.next()) {
                Order order = (Order) DBUtil.getInstance().columnBinding(new Order(), resultSet);
                orders.add(order);
            }
            return orders;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
