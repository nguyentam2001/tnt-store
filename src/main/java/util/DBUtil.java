package util;

import java.sql.Connection;
import java.sql.DriverManager;

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
}
