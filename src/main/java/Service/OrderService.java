package Service;

import Model.Inline_item;
import Model.Order;

import java.sql.*;
import java.util.List;
import java.util.concurrent.Callable;

public class OrderService {
    private String jdbcUrl="jdbc:mysql://localhost:3306/bakery_website?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
        }catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public boolean insertOrder(Order order) {
        String query = "insert into orders" + "(order_date, customer_name, " +
                "customer_email, customer_phone, customer_address) values " + "(?,?,?,?,?)";
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setDate(1,  order.getOrderDate());
            preparedStatement.setString(2, order.getCustomerName());
            preparedStatement.setString(3, order.getCustomerEmail());
            preparedStatement.setString(4, order.getCustomerPhone());
            preparedStatement.setString(5, order.getCustomerAddress());
            int result = preparedStatement.executeUpdate();
            if (result > 0) return true;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getOrderId() {
        String store = "CALL getIdmax(); ";
        try (Connection connection = getConnection();
        CallableStatement cs = connection.prepareCall(store)){
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("order_id");
                return id;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean insertOrderDetail(Order order,int id) {
        String query = "insert into order_detail" + "(product_id, order_id, order_amount, unit_price) values"
                + "(?,?,?,?)";
        List<Inline_item> list = order.getInlineItem();
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)){

            for (Inline_item item : list) {
                preparedStatement.setInt(1, item.getProduct().getProductId());
                preparedStatement.setInt(2, id);
                preparedStatement.setInt(3, item.getAmount());
                preparedStatement.setFloat(4, item.getUnitPrice());
                int result = preparedStatement.executeUpdate();
            }
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



//    public void insertOrderUsingTransaction(Order order) throws SQLException {
//        String query1 = "insert into orders" + "(order_date, customer_name, " +
//                "customer_email, customer_phone, customer_address) values " + "(?,?,?,?,?)";
//
//        String query2 = "insert into order_detail" + "(product_id, order_id, order_amount, unit_price) values"
//                + "(?,?,?,?)";
//        List<Inline_item> list = order.getInlineItem();
//
//        try (Connection connection = getConnection();
//             PreparedStatement psInsertOrder = connection.prepareStatement(query1);
//             PreparedStatement psInsertDetail = connection.prepareStatement(query2)){
//            connection.setAutoCommit(false);
//
//            psInsertOrder.setDate(1,  order.getOrderDate());
//            psInsertOrder.setString(2, order.getCustomerName());
//            psInsertOrder.setString(3, order.getCustomerEmail());
//            psInsertOrder.setString(4, order.getCustomerPhone());
//            psInsertOrder.setString(5, order.getCustomerAddress());
//            psInsertOrder.executeUpdate();
//
//            for (Inline_item item : list) {
//                psInsertDetail.setInt(1, item.getProduct().getProductId());
//                psInsertDetail.setInt(2, order.getOrderId());
//                psInsertDetail.setInt(3, item.getAmount());
//                psInsertDetail.setFloat(4, item.getUnitPrice());
//                int result = psInsertDetail.executeUpdate();
//
//            }
//
//
//            connection.commit();
//
//            connection.setAutoCommit(true);
//
//        }catch (SQLException e) {
//            getConnection().rollback();
//            e.printStackTrace();
//        }
//    }
}
