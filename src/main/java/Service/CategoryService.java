package Service;

import Model.Category;

import java.sql.*;

public class CategoryService {
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

    public Category getCategoryById(int id) {
        String query = "SELECT * FROM category WHERE category_id = " + id;
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
        ){
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                int category_id = rs.getInt("category_id");
                String categoryName = rs.getString("category_name");
                Category category = new Category(category_id, categoryName);
                return category;
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
