package service.impl;

import dao.OrderDAO;
import dao.impl.OrderDAOImpl;
import model.Order;
import service.OrderService;
import util.Resources;
import util.Validator;
import view.CommonView;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDAO orderDAO;
    public OrderServiceImpl() {
        orderDAO = new OrderDAOImpl();
    }
    @Override
    public boolean save(Order order) {
        if (Validator.getInstance().checkEmpty(order.getName()))
            return false;
        else
            return orderDAO.save(order) > 0;
    }

    @Override
    public boolean delete(int id) {
        Order order = orderDAO.getById(id);
        if (order != null) {
            return orderDAO.delete(id) > 0;
        } else {
            CommonView.getInstance().displayMessage(Resources.ORDER_NOT_EXIST + id);
        }
        return false;
    }

    @Override
    public List findAll() {
        return orderDAO.findAll();
    }

    @Override
    public boolean update(int id, Order order) {
        Order currOrder = orderDAO.getById(id);
        if (currOrder != null) {
            return orderDAO.update(id, order) > 0;
        } else {
            CommonView.getInstance().displayMessage(Resources.ORDER_NOT_EXIST + id);
        }
        return false;
    }

    @Override
    public int saveAndGetOrderId(Order order) {
        return orderDAO.save(order);
    }

    @Override
    public List<Order> getOrdersByPhone(String phone) {
        return orderDAO.getOrderByPhone(phone);
    }
}
