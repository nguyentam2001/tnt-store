package dao;

import model.OrderDetail;

import java.util.List;

public interface OrderDetailDAO extends CommonDAO<OrderDetail> {
    List<OrderDetail> getOrderDetailByOrderId(int orderId);
}
