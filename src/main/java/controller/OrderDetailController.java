package controller;


public class OrderDetailController {
    private static OrderDetailController instance;

    public static OrderDetailController getInstance() {
        return instance = instance == null ? new OrderDetailController() : instance;
    }

}
