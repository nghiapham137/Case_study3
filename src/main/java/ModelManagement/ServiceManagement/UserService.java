package ModelManagement.ServiceManagement;

//Trong này sẽ chứa các thao tác của user như:
//      Login

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ModelManagement.DataAccessLayer.ConnectDatabase;

public class UserService {

    public boolean login(String username, String password) {
        boolean isLogin = false;

        try {
            Connection conn = ConnectDatabase.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users");
            while (resultSet.next()) {
                String name = resultSet.getString(3);
                String pass = resultSet.getString(4);
                if (name.equals(username) && pass.equals(password)) {
                    isLogin = true;
                }
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }

        return isLogin;
    }

}
