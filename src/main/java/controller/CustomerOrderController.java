package controller;

import model.*;
import service.*;
import service.impl.*;
import util.Resources;
import util.Validator;
import view.AddressView;
import view.CommonView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerOrderController {
    private final Scanner scanner;

    private static CustomerOrderController instance;
    private List<Address> addresses;

    private final CustomerService customerService;
    private final AddressService addressService;
    private final ProductService productService;
    private final DiscountService discountService;
    private final OrderDetailService orderDetailService;
    private final OrderService orderService;
    private List<OrderDetail> orderDetails;
    private Order order;
    private OrderDetail orderDetail;
    private int customerId;
    private String phoneNumber;

    public CustomerOrderController() {
        scanner = new Scanner(System.in);
        orderDetailService = new OrderDetailServiceImpl();
        customerService = new CustomerServiceImpl();
        addresses = new ArrayList<>();
        addressService = new AddressServiceImpl();
        order = new Order();
        orderDetail = new OrderDetail();
        productService = new ProductServiceImpl();
        orderDetails = new ArrayList<>();
        orderService = new OrderServiceImpl();
        discountService = new DiscountServiceImpl();

    }

    public static CustomerOrderController getInstance() {
        return instance = instance == null ? new CustomerOrderController() : instance;
    }

    public void orderProduct() {
        getProductPick();
        getCustomerInfo();
        saveOrder();
    }

    private void getProductPick() {
        orderDetails = new ArrayList<>();//Khởi tạo một orderdetails mới
        ProductController.getInstance().printProducts();
        int pick;
        do {
            System.out.print("\tEnter Id product you choose: ");
            int id = scanner.nextInt();
            System.out.print("\tEnter quantity: ");
            int quantity = scanner.nextInt();
            addOrderDetails(addProductToOrderDetail(id, quantity), orderDetails);
            System.out.print("\tEnter 0 to exit: ");
            pick = scanner.nextInt();
            scanner.nextLine();
        } while (pick != 0);
    }

    private void getCustomerInfo() {
        phoneNumber = Validator.getInstance().phoneValidate();
        Customer customer = customerService.getCustomerByPhone(phoneNumber);
        if (customer != null) {
            CustomerController.getInstance().printCustomer(customer);
            customerId = customer.getCustomerId();
        } else {
            customerId = CustomerController.getInstance().saveCustomerController();
        }
    }

    public Order inputOrder(List<Address> addresses) {
        order = new Order();
        System.out.print("\tEnter order name: ");
        order.setName(scanner.nextLine());
        order.setPhoneNumber(phoneNumber);
        System.out.println("\tChoose delivery address");
        AddressView.printAddress(addresses);
        System.out.print("\tEnter delivery address Id: ");
        order.setAddressId(scanner.nextInt());
        scanner.nextLine();
        System.out.print("\tEnter detail address: ");
        order.setDetailAddress(scanner.nextLine());
        order.setTotal(sumPriceOrder(orderDetails));//tổng hoá đơn
        order.setOrderDate(Validator.getInstance().currDate());
        order.setCustomerId(customerId);//id khách hàng
        System.out.println("\tChoose discount");
        DiscountController.getInstance().printAllDiscountController();
        System.out.print("\tEnter discountId: ");
        order.setDiscountId(scanner.nextInt());
        scanner.nextLine();
        return order;
    }

    public long getDeliveryFreeByAddressId(int addressId) {
        long deliveryFree = 0;
        Address address = addressService.getAddressById(addressId);
        if (address != null) {
            deliveryFree = address.getDeliveryFree();
        }
        return deliveryFree;
    }

    //tính giảm giá
    public int discountPriceOrderDetailCal(long total, double percent) {
        return (int) (total - total * 1.0 * percent / 100.0);
    }

    public void saveOrder() {
        //save và lấy id của order.
        addresses = addressService.findAll();
        order = inputOrder(addresses);
        Discount discount = discountService.getDiscountById(order.getDiscountId());
        order.setTotal(//Tiền hàng và phí ship
                discountPriceOrderDetailCal(order.getTotal() + getDeliveryFreeByAddressId(order.getAddressId()),
                        discount.getDiscountPrice()));//Tính toán mã giám giá
        int orderId = orderService.saveAndGetOrderId(order);
        saveOrderDetailOrderId(orderId);
    }

    private void saveOrderDetailOrderId(int orderId) {
        try {
            for (OrderDetail odt :
                    orderDetails) {
                odt.setOrderId(orderId);
                orderDetailService.save(odt);//lưu lần lượt vào sql
            }
            CommonView.getInstance().displayMessage(Resources.ORDER_SUCCESS);
        } catch (Exception e) {
            CommonView.getInstance().displayMessage(Resources.ORDER_FAIL);
        }


    }

    public int sumPriceOrder(List<OrderDetail> orderDetails) {
        int sum = 0;
        for (OrderDetail odt :
                orderDetails) {
            sum += (int) odt.getTotal();
        }
        return sum;
    }

    public OrderDetail addProductToOrderDetail(int id, int quantity) {
        orderDetail = new OrderDetail();//tạo một order mới
        Product product = productService.getProductById(id);
        if (product != null) {
            if (product.getStock() < quantity) {
                System.out.println("\t" + Resources.PRODUCT_NOT_ENOUGH);
            } else {
                orderDetail.setQuantity(quantity);
                orderDetail.setProductId(id);
                orderDetail.setTotal((quantity * product.getPrice()) - (int) product.getDiscountPrice());//lấy tổng số giá tiền của order
                orderDetail.setOrderId(0);//mặc đinh cho id là 0
                return orderDetail;
            }
        }
        return orderDetail;
    }

    public void addOrderDetails(OrderDetail orderDetail, List<OrderDetail> orderDetails) {
        //Kiểm tra xem sản phẩm đã tồn tại trong danh sách order detail chưa nếu tồn tại thì cộng thêm số lượng sản phẩm
        if (isExistProductInOrders(orderDetail.getProductId(), orderDetails)) {
            OrderDetail orderDetailProduct = new OrderDetail(orderDetail.getProductId());
            int index = orderDetails.indexOf(orderDetailProduct);
            OrderDetail orderDetailProductOld = orderDetails.get(index);
            int quantityNew = orderDetailProductOld.getQuantity() + orderDetail.getQuantity();
            OrderDetail orderDetailProductNew = addProductToOrderDetail(orderDetailProductOld.getProductId(), quantityNew);
            if (orderDetailProductNew != null) {
                orderDetails.set(index, orderDetailProductOld);
            }
        } else if (orderDetail.getProductId() != 0) {
            orderDetails.add(orderDetail);
        }

    }

    public boolean isExistProductInOrders(int id, List<OrderDetail> orderDetails) {
        for (OrderDetail order :
                orderDetails) {
            if (order.getProductId() == id)
                return true;
        }
        return false;
    }


    public void checkReceipt() {
        phoneNumber = Validator.getInstance().phoneValidate().trim();
        Customer customer = customerService.getCustomerByPhone(phoneNumber);
        if (customer != null) {
            List<Order> orders = orderService.getOrdersByPhone(phoneNumber);
            if (orders.size() > 0) {
                System.out.println(Resources.ORDER_TITLE);
                OrderController.getInstance().printLimitedOrderController(orders);//Hiển thị danh sách hoá đơn
                System.out.println(Resources.PRODUCT_ORDER_TITLE);
                for (Order order :
                        orders) {
                    orderDetails = orderDetailService.getOrderDetailByOrderId(order.getOrderId());
                    printOrderDetailController(orderDetails);
                }
            } else {
                System.out.println(Resources.ORDER_EMPTY);
            }
        }
    }

    public void printOrderDetailController(List<OrderDetail> orderDetails) {
        CommonView.getInstance().printLineLimit(70);
        CommonView.getInstance().printTitleLimit(Resources.ORDER_PRODUCT_TITLES);
        CommonView.getInstance().printLineLimit(70);
        for (OrderDetail odt :
                orderDetails) {
            Product product = productService.getProductById(odt.getProductId());
            CommonView.getInstance().printLimit(product.getName(), odt.getQuantity(), odt.getTotal());
        }
        CommonView.getInstance().printLineLimit(70);
    }

}
