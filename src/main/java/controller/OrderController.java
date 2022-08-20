
package controller;

import model.Address;
import model.Order;
import service.AddressService;
import service.DiscountService;
import service.OrderService;
import service.impl.AddressServiceImpl;
import service.impl.DiscountServiceImpl;
import service.impl.OrderServiceImpl;
import util.Resources;
import util.Validator;
import view.CommonView;
import view.OrderView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderController {
    private OrderService orderService;
    private Order order;
    private static OrderController instance;
    private AddressService addressService;
    private DiscountService discountService;

    public OrderController() {
        order = new Order();
        orderService = new OrderServiceImpl();
        addressService = new AddressServiceImpl();
        discountService = new DiscountServiceImpl();
    }

    public static OrderController getInstance() {
        return instance = instance == null ? new OrderController() : instance;
    }

    public void menuOrderController() {
        int pick = 0;
        do {
            OrderView.printViewOrder();
            pick = Main.scanner.nextInt();
            switch (pick) {

                case 1:
                    saveOrderController();
                    break;
                case 2:
                    printAllOrderController();
                    break;
                case 3:
                    updateOrderController();
                    break;
                case 4:
                    deleteOrderController();
                    break;
                case 5:
                    findOrderByIdController();
                    break;
                default:
                    break;
            }

        } while (pick != 0);
    }

    private void findOrderByIdController() {
    }

    public void saveOrderController() {
        boolean isCon;
        do {
            order = OrderView.inputOrder(addressService.findAll());
            boolean result = orderService.save(order);
            if (result) {
                CommonView.getInstance().displayMessage(Resources.ADD_SUCCESS_MSG);
            } else {
                CommonView.getInstance().displayMessage(Resources.ADD_FAIL_MSG);
            }
            isCon = Main.isContinue();
        } while (isCon);

    }

    public void deleteOrderController() {
        int id = CommonView.getInstance().inputId(Resources.ORDER_TITLE);
        boolean result = orderService.delete(id);
        if (result) {
            CommonView.getInstance().displayMessage(Resources.DELETE_SUCCESS_MSG);
        } else {
            CommonView.getInstance().displayMessage(Resources.DELETE_FAIL_MSG);
        }
    }

    public void printAllOrderController() {
        List<Order> orders = orderService.findAll();
        OrderView.titleOrder();
        for (Order order :
                orders) {
            OrderView.printOrder(order);
        }
        OrderView.printLineOrder();
    }

    public void updateOrderController() {
        //nhập id muốn update
        boolean isCon = true;

        do {
            int id = CommonView.getInstance().inputId(Resources.ORDER_TITLE);
            order = OrderView.inputOrder(addressService.findAll());
            boolean result = orderService.update(id, order);
            if (result) {
                CommonView.getInstance().displayMessage(Resources.UPDATE_SUCCESS_MSG);
            } else {
                CommonView.getInstance().displayMessage(Resources.UPDATE_FAIL_MSG);
            }
            isCon = Main.isContinue();
        } while (isCon);

    }

    public void printLimitedOrderController(List<Order> orders) {
        CommonView.getInstance().printLineLimit(116);
        CommonView.getInstance().printTitleLimit(Resources.ORDER_LIMIT_TITLES);
        CommonView.getInstance().printLineLimit(116);
        for (Order order :
                orders) {
            CommonView.getInstance().printLimit(order.getOrderId(), order.getName(), order.getDetailAddress(), order.getTotal(), order.getOrderDate());
        }
        CommonView.getInstance().printLineLimit(116);
    }
}
