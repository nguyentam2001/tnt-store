package service.impl;

import dao.OrderDetailDAO;
import dao.impl.OrderDetailDAOImpl;
import model.OrderDetail;
import service.OrderDetailService;

import java.util.List;

public class OrderDetailServiceImpl  implements OrderDetailService {
    OrderDetailDAO orderDetailDAO;
    public OrderDetailServiceImpl(){
        orderDetailDAO= new OrderDetailDAOImpl();
    }
    @Override
    public boolean save(OrderDetail orderDetail) {
       return orderDetailDAO.save(orderDetail)>0;
    }

    @Override
    public boolean delete(int id) {
        return orderDetailDAO.delete(id)>0;
    }

    @Override
    public List<OrderDetail> findAll() {
        return orderDetailDAO.findAll();
    }

    @Override
    public boolean update(int id, OrderDetail orderDetail) {
        return orderDetailDAO.update(id,orderDetail)>0;
    }

    @Override
    public List<OrderDetail> getOrderDetailByOrderId(int orderId) {
        return orderDetailDAO.getOrderDetailByOrderId(orderId);
    }
}
