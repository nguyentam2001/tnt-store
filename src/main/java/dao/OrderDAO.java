package dao;

import model.Order;

import java.util.List;

public interface OrderDAO extends CommonDAO<Order>{
    List<Order> getOrderByPhone(String phone);
}
