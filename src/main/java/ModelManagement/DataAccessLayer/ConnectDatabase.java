package ModelManagement.DataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDatabase {

    public static Connection getConnection() {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/bakery_website?useSSL=false";
        String username = "root";
        String password = "123456";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return conn;
    }

}
