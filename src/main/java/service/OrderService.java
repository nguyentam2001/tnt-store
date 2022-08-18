package service;

import model.Order;

import java.util.List;

public interface OrderService extends CommonService<Order>{
    int saveAndGetOrderId(Order order);
    List<Order> getOrdersByPhone(String phone);
}
