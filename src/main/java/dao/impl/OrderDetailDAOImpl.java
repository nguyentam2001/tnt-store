package dao.impl;

import dao.OrderDetailDAO;
import model.OrderDetail;
import util.DBUtil;
import util.Resources;
import view.CommonView;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    @Override
    public int save(OrderDetail orderDetail) {
        try (Connection connection = DBUtil.getInstance().getConnection()) {
            String sql = Resources.INSERT_ORDER_DETAIL;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement = DBUtil.getInstance().statementBinding(preparedStatement, orderDetail.getQuantity(),
                    orderDetail.getTotal(), orderDetail.getOrderId(), orderDetail.getProductId());
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
        try (Connection connection = DBUtil.getInstance().getConnection();
        ) {
            String sql = Resources.DELETE_ORDER_DETAIL + id;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<OrderDetail> findAll() {
        try (Connection connection = DBUtil.getInstance().getConnection();
             Statement statement = connection.createStatement()) {
            String sql = Resources.SELECT_ALL_ORDER_DETAIL;
            ResultSet resultSet = statement.executeQuery(sql);
            List<OrderDetail> orderDetails = new ArrayList<>();
            while (resultSet.next()) {
                OrderDetail orderDetail = (OrderDetail) DBUtil.getInstance().columnBinding(new OrderDetail(), resultSet);
                orderDetails.add(orderDetail);
            }
            return orderDetails;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public OrderDetail getById(int id) {
        try (Connection connection = DBUtil.getInstance().getConnection();
             Statement statement = connection.createStatement()) {
            String sql = Resources.SELECT_ORDER_DETAIL_BY_ID + id;
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return (OrderDetail) DBUtil.getInstance().columnBinding(new OrderDetail(), resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int update(int id, OrderDetail orderDetail) {
        try (Connection connection = DBUtil.getInstance().getConnection()) {
            String sql = Resources.UPDATE_ORDER_DETAIL;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement = DBUtil.getInstance().statementBinding(preparedStatement, orderDetail.getQuantity(),
                    orderDetail.getTotal(), orderDetail.getOrderId(), orderDetail.getProductId(), id);
            if (preparedStatement != null) {
                return preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    @Override
    public List<OrderDetail> getOrderDetailByOrderId(int orderId) {
        try (Connection connection = DBUtil.getInstance().getConnection()) {
            Statement statement = connection.createStatement();
            String sql = Resources.SELECT_ORDER_DETAIL_BY_ORDER_ID + orderId;
            ResultSet resultSet = statement.executeQuery(sql);
            List<OrderDetail> orderDetails = new ArrayList<>();
            while (resultSet.next()) {
                orderDetails.add((OrderDetail) DBUtil.getInstance().columnBinding(new OrderDetail(), resultSet));
            }
            return orderDetails;
        } catch (SQLException e) {
            CommonView.getInstance().displayMessage(e.getMessage());
        }
        return null;
    }
}
