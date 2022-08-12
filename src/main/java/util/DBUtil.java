package util;

import model.Address;

import java.sql.*;

public class DBUtil {
    private static DBUtil instance;

    public static DBUtil getInstance() {
        return instance = instance != null ? instance : new DBUtil();
    }

    public Connection getConnection() {
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=TNT_STORE;";
            String username = "sa";
            String password = "tam060601";
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
        if(object instanceof Address){
                int id = resultSet.getInt("ADDRESS_ID");
                String city = resultSet.getString("CITY");
                String district = resultSet.getString("DISTRICT");
                String subDistrict = resultSet.getString("SUB_DISTRICT");
                String postalCode = resultSet.getString("POSTAL_CODE");
                Long deliveryFee = resultSet.getLong("DELIVERY_FEE");
                Address address= new Address(id, city, district, subDistrict, postalCode, deliveryFee);
                return  address;
        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
