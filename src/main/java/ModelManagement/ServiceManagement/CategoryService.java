package ModelManagement.ServiceManagement;

import ModelManagement.DataAccessLayer.ConnectDatabase;
import ModelManagement.Entities.Category;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();
        try {
            Connection connection = ConnectDatabase.getConnection();
            String query = "SELECT * FROM category;";
            CallableStatement callableStatement = connection.prepareCall(query);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                categories.add(new Category(id, name));
            }
            connection.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return categories;
    }

    public boolean create(Category category) {
        boolean isCreated = false;
        try {
            Connection connection = ConnectDatabase.getConnection();
            String query = "INSERT INTO category " + "(category_name = ?) VALUES" + "(?);";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, category.getCategoryName());
            isCreated = statement.executeUpdate() > 0;
            connection.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return isCreated;
    }

    public boolean update(Category category) {
        boolean isUpdated = false;
        String query = "UPDATE category SET category_name = ? WHERE category_id = ?;";
        try {
            Connection connection = ConnectDatabase.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, category.getCategoryName());
            statement.setInt(2, category.getCategoryId());
            isUpdated = statement.executeUpdate() > 0;
            connection.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return isUpdated;
    }

    public boolean delete (int id) {
        boolean isDeleted = false;
        String query = "DELETE FROM category WHERE category_id = ?;";
        try {
            Connection connection = ConnectDatabase.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            isDeleted = statement.executeUpdate() > 0;
            connection.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return isDeleted;
    }
}
