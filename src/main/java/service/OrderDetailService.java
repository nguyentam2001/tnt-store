package service;

import model.OrderDetail;

import java.util.List;

public interface OrderDetailService extends  CommonService<OrderDetail>{
    List<OrderDetail> getOrderDetailByOrderId(int orderId);
}
