package ModelManagement.ServiceManagement;

import Model.Inline_item;
import Model.Product;
import ModelManagement.DataAccessLayer.ConnectDatabase;
import ModelManagement.Entities.Order;
import Service.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderService {
    Service service = new Service();
    public List<Order> getAll() {
        List<Order> orders = new ArrayList<>();
        List<Inline_item> itemList = new ArrayList<>();
        String query = "CALL select_all_order();";
        try (Connection connection = ConnectDatabase.getConnection();
             CallableStatement statement = connection.prepareCall(query)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("order_id");
                Date date = resultSet.getDate("order_date");
                String name= resultSet.getString("customer_name");
                String email = resultSet.getString("customer_email");
                String phone = resultSet.getString("customer_phone");
                String address = resultSet.getString("customer_address");
                int productId = resultSet.getInt("product_id");
                int amount = resultSet.getInt("order_amount");
                float price = resultSet.getFloat("unit_price");
                itemList.add(new Inline_item(service.getProductById(productId), amount, price));
                orders.add(new Order(id, date, name, email, phone, address, itemList));
            }
            connection.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return orders;
    }

}
