package ModelManagement.ServiceManagement;

import ModelManagement.DataAccessLayer.ConnectDatabase;
import ModelManagement.Entities.Category;
import ModelManagement.Entities.Product;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    public List<Product> getAll() {
        List<Product> productList = new ArrayList<>();
        try {
            Connection connection = ConnectDatabase.getConnection();
            String query = "{CALL show_all_product_for_admin()}";
            CallableStatement callableStatement = connection.prepareCall(query);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int idProduct = resultSet.getInt(1);
                String nameProduct = resultSet.getString(2);
                int amountProduct = resultSet.getInt(3);
                Float priceProduct = resultSet.getFloat(4);
                String thumbnailProduct = resultSet.getString(5);
                String descriptionProduct = resultSet.getString(6);
                int categoryId = resultSet.getInt(7);
                String categoryName = resultSet.getString(8);
                productList.add(new Product(idProduct, nameProduct, amountProduct, priceProduct, descriptionProduct, thumbnailProduct, new Category(categoryId, categoryName)));
            }
            connection.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return productList;
    }

    public boolean delete(int id) {
        boolean isDeleted = false;
        try {
            Connection connection = ConnectDatabase.getConnection();
            String query = "{CALL removeProduct(?)}";
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt(1, id);
            isDeleted = callableStatement.executeUpdate() > 0;
            connection.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return isDeleted;
    }

    public boolean create(Product product) {
        boolean isCreate = false;
        String query = "INSERT INTO product " + "(product_name,  amount, price, description, thumbnail, category_id) VALUES " + "(?, ?, ?, ?, ?, ?);";
        try {
            Connection connection = ConnectDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            System.out.println(query);
            preparedStatement.setString(1,product.getProductName());
            preparedStatement.setInt(2, product.getAmount());
            preparedStatement.setFloat(3, product.getPrice());
            preparedStatement.setString(4, product.getDescription());
            preparedStatement.setString(5, product.getThumbnail());
            preparedStatement.setInt(6, product.getCategory().getCategoryId());
            isCreate = preparedStatement.executeUpdate() > 0;
            connection.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return isCreate;
    }

    public boolean update(Product product) {
        boolean isUpdate = false;
        String query = "UPDATE product SET product_name=?,  amount=?, price=?, description=?, thumbnail=?, category_id=? WHERE product_id=?;";
        try {
            Connection connection = ConnectDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setInt(2, product.getAmount());
            preparedStatement.setFloat(3, product.getPrice());
            preparedStatement.setString(4, product.getDescription());
            preparedStatement.setString(5, product.getThumbnail());
            preparedStatement.setInt(6, product.getCategory().getCategoryId());
            preparedStatement.setInt(7, product.getProductId());
            isUpdate = preparedStatement.executeUpdate() > 0;
            connection.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return isUpdate;
    }
}
