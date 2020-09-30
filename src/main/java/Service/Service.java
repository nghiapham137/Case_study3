package Service;

import Model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Service implements Iservice{
    CategoryService categoryService = new CategoryService();
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

    @Override
    public List<Product> showAllProducts() {
        List<Product> productList = new ArrayList<>();
        String query = "{CALL show_all_product_for_customer()}";
        try (Connection connectionService = getConnection();
             CallableStatement cs = connectionService.prepareCall(query)){
            ResultSet resultSet = cs.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("product_id");
                String productName = resultSet.getString("product_name");
                Float price = resultSet.getFloat("price");
                int amount = resultSet.getInt("amount");
                String thumbnail = resultSet.getString("thumbnail");
                String description = resultSet.getString("description");
                int category_id = resultSet.getInt("category_id");
                productList. add(new Product(id, productName, amount, price, description, thumbnail, categoryService.getCategoryById(category_id)));
            }
            return productList;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Product getProductById(int id) {
        Product product = null;
        String query = "select * from product where product_id = " + id + ";";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();){
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                String productName = resultSet.getString("product_name");
                int amount = resultSet.getInt("amount");
                Float price = resultSet.getFloat("price");
                String thumbnail = resultSet.getString("thumbnail");
                String description = resultSet.getString("description");
                int category_id = resultSet.getInt("category_id");
                product = new Product(productId, productName, amount, price, thumbnail, description, categoryService.getCategoryById(category_id));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }
    public List<Product>searchBy(String search) {
        List<Product> productList = new ArrayList<>();
        String query = "{CALL search_by(?)}";
        try (Connection connectionService = getConnection();
             CallableStatement cs = connectionService.prepareCall(query)) {
            cs.setString(1,search);
            ResultSet resultSet = cs.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("product_id");
                String productName = resultSet.getString("product_name");
                Float price = resultSet.getFloat("price");
                int amount = resultSet.getInt("amount");
                String thumbnail = resultSet.getString("thumbnail");
                String description = resultSet.getString("description");
                int category_id = resultSet.getInt("category_id");
                productList.add(new Product(id, productName, amount, price, description, thumbnail, categoryService.getCategoryById(category_id)));
            }
            return productList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
