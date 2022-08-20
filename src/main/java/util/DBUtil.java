package util;

import model.*;

import java.sql.*;
import java.time.LocalDate;

public class DBUtil {
    private static DBUtil instance;

    public static DBUtil getInstance() {
        return instance = instance != null ? instance : new DBUtil();
    }

    public Connection getConnection() {
        try {
            String url = Resources.DB_URL;
            String username = Resources.DB_NAME;
            String password = Resources.DB_PASS;
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public PreparedStatement statementBinding(PreparedStatement preparedStatement, Object... args) {
        try {
            for (int i = 0; i < args.length; i++) {
                if (args[i] instanceof String) {
                    preparedStatement.setString(i + 1, (String) args[i]);
                } else if (args[i] instanceof Long) {
                    preparedStatement.setLong(i + 1, (Long) args[i]);
                } else if (args[i] instanceof Integer) {
                    preparedStatement.setInt(i + 1, (Integer) args[i]);
                } else if (args[i] instanceof LocalDate) {
                    preparedStatement.setObject(i + 1, args[i]);
                } else if (args[i] instanceof Double) {
                    preparedStatement.setDouble(i + 1, (Double) args[i]);
                } else {
                    System.out.println("MISSING TYPE: " + args[i].getClass());
                }
            }
            return preparedStatement;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object columnBinding(Object object, ResultSet resultSet) {
        try {
            if (object instanceof Address) {
                int id = resultSet.getInt("ADDRESS_ID");
                String city = resultSet.getString("CITY");
                String district = resultSet.getString("DISTRICT");
                String subDistrict = resultSet.getString("SUB_DISTRICT");
                String postalCode = resultSet.getString("POSTAL_CODE");
                Long deliveryFee = resultSet.getLong("DELIVERY_FEE");
                Address address = new Address(id, city, district, subDistrict, postalCode, deliveryFee);
                return address;
            } else if (object instanceof Customer) {
                int id = resultSet.getInt("CUSTOMER_ID");
                String fullName = resultSet.getString("FULL_NAME");
                String phoneNumber = resultSet.getString("PHONE_NUMBER");
                String email = resultSet.getString("EMAIL");
                int address = resultSet.getInt("ADDRESS_ID");
                Customer customer = new Customer(id, fullName, phoneNumber, email, address);
                return customer;
            } else if (object instanceof Discount) {
                int id = resultSet.getInt("DISCOUNT_ID");
                String title = resultSet.getString("TITLE");
                String type = resultSet.getString("TYPE");
                Double discountPrice = resultSet.getDouble("DISCOUNT_PRICE");
                LocalDate startDate = resultSet.getDate("START_DATE").toLocalDate();
                LocalDate endDate = resultSet.getDate("END_DATE").toLocalDate();
                Discount discount = new Discount(id, title, type, discountPrice, startDate, endDate);
                return discount;
            } else if (object instanceof Order) {
                int id = resultSet.getInt("ORDER_ID");
                String name = resultSet.getString("NAME");
                String phoneNumber = resultSet.getString("PHONE_NUMBER");
                String detailAddress = resultSet.getString("DETAIL_ADDRESS");
                int total = resultSet.getInt("TOTAL");
                LocalDate orderDate = resultSet.getDate("ORDER_DATE").toLocalDate();
                int customerId = resultSet.getInt("CUSTOMER_ID");
                int addressId = resultSet.getInt("ADDRESS_ID");
                int discountId = resultSet.getInt("DISCOUNT_ID");
                Order order = new Order(id, name, phoneNumber, detailAddress, total, orderDate, customerId, addressId, discountId);
                return order;
            } else if (object instanceof OrderDetail) {
                int id = resultSet.getInt("CART_ID");
                int quantity = resultSet.getInt("QUANTITY");
                long total = resultSet.getLong("TOTAL");
                int orderId = resultSet.getInt("ORDER_ID");
                int productId = resultSet.getInt("PRODUCT_ID");
                OrderDetail orderDetail = new OrderDetail(id, quantity, total, orderId, productId);
                return orderDetail;
            } else if (object instanceof Product) {
                int id = resultSet.getInt("PRODUCT_ID");
                String name = resultSet.getString("NAME");
                String description = resultSet.getString("DESCRIPTION");
                long price = resultSet.getLong("PRICE");
                double discountPrice = resultSet.getDouble("DISCOUNT_PRICE");
                double stock = resultSet.getDouble("STOCK");
                int sold = resultSet.getInt("SOLD");
                LocalDate date = resultSet.getDate("CREATE_DATE").toLocalDate();
                int status = resultSet.getInt("STATUS");
                Product product = new Product(id, name, description, price, discountPrice, stock, sold, date, status);
                return product;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("MISSING TYPE: " + object.getClass());
        return null;
    }
}
