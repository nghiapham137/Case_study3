package ModelManagement.ServiceManagement;

import ModelManagement.DataAccessLayer.ConnectDatabase;
import ModelManagement.Entities.Order;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderService {
    public List<Order> getAll() {
        List<Order> orders = new ArrayList<>();
        String query = "{CALL }";
        try {
            Connection connection = ConnectDatabase.getConnection();
            CallableStatement statement = connection.prepareCall(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                Date date = resultSet.getDate(2);
                String name = resultSet.getString(3);
                String email = resultSet.getString(4);
                String phone = resultSet.getString(5);
                String address = resultSet.getString(6);
//                orders.add(new Order(date, name, email, phone, address, ));
            }
            connection.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return orders;
    }
}
