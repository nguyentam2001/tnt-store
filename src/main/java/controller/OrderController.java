package controller;

import model.Address;
import model.Order;
import service.AddressService;
import service.OrderService;
import service.impl.AddressServiceImpl;
import service.impl.OrderServiceImpl;
import util.Resources;
import view.CommonView;
import view.address.AddressView;
import view.order.OrderView;

import java.util.List;

public class OrderController {
    private static OrderService orderService;
    private static Order order;
    private  static  OrderController instance;

    public OrderController() {
        order = new Order();
        orderService = new OrderServiceImpl();
    }

    public static   OrderController  getInstance(){
        return  instance=instance==null?new OrderController():instance;
    }

    public  void  menuOrderController(){
        int pick=0;
        do {
            OrderView.printViewOrder();
            pick=Main.scanner.nextInt();
            switch (pick){
                case 1:saveOrderController(); break;
                case 2:printAllOrderController(); break;
                case 3:updateOrderController();break;
                case 4:deleteOrderController(); break;
                case 5:findOrderByIdController();break;
                default: break;
            }

        }while (pick!=0);
    }

    private void findOrderByIdController() {
    }

    public  void saveOrderController() {
        boolean isCon;
        do {
            order = OrderView.inputOrder();
            boolean result=orderService.save(order);
            if(result){
                CommonView.getInstance().displayMessage(Resources.ADD_SUCCESS_MSG);
            }else {
                CommonView.getInstance().displayMessage(Resources.ADD_FAIL_MSG);
            }
            isCon=Main.isContinue();
        }while (isCon);

    }

    public void  deleteOrderController(){
        int id=CommonView.getInstance().inputId("Order");
        boolean result= orderService.delete(id);
        if(result){
            CommonView.getInstance().displayMessage(Resources.DELETE_SUCCESS_MSG);
        }else{
            CommonView.getInstance().displayMessage(Resources.DELETE_FAIL_MSG);
        }
    }

    public void printAllOrderController(){
        List<Order> orders = orderService.findAll();
        OrderView.titleOrder();
        for (Order order :
                orders) {
            OrderView.printOrder(order);
        }
        OrderView.printLineOrder();
    }

    public  void  updateOrderController(){
        //nhập id muốn update
        boolean isCon=true;
        do {
            int id=CommonView.getInstance().inputId("Order");
            order = OrderView.inputOrder();
            boolean result= orderService.update(id,order);
            if(result){
                CommonView.getInstance().displayMessage(Resources.UPDATE_SUCCESS_MSG);
            }else{
                CommonView.getInstance().displayMessage(Resources.UPDATE_FAIL_MSG);
            }
            isCon=Main.isContinue();
        }while (isCon);

    }

}