package org.mark.app.manager;

import org.mark.app.App;
import org.mark.app.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Product_Manager {

    public static void insert(Product product) throws SQLException {
        try (Connection c = App.getConnection()) {
            String sql = "INSERT INTO Product(Title, ProductType, ArticleNumber, Description, Image, ProductionPersonCount, ProductionWorkshopNumber, MinCostForAgent) VALUE(?,?,?,?,?,?,?,?)";
            PreparedStatement pr = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pr.setString(1, product.getTitle());
            pr.setString(2, product.getProductType());
            pr.setInt(3, product.getArticleNumber());
            pr.setString(4, product.getDescription());
            pr.setString(5, product.getImage());
            pr.setInt(6, product.getProductionPersonCount());
            pr.setInt(7, product.getProductionWorkshopNumber());
            pr.setInt(8, product.getMinCostForAgent());

            pr.executeUpdate();

            ResultSet keys = pr.getGeneratedKeys();

            if (keys.next()) {
                product.setID(keys.getInt(1));
            }
        }
    }


    public static void update(Product product) throws SQLException {
        try (Connection c = App.getConnection()) {
            String sql = "UPDATE Product SET Title=?, ProductType=?, ArticleNumber=?, Description=?, Image=?, ProductionPersonCount=?, ProductionWorkshopNumber=?, MinCostForAgent=? WHERE ID=?";
            PreparedStatement pr = c.prepareStatement(sql);

            pr.setString(1, product.getTitle());
            pr.setString(2, product.getProductType());
            pr.setInt(3, product.getArticleNumber());
            pr.setString(4, product.getDescription());
            pr.setString(5, product.getImage());
            pr.setInt(6, product.getProductionPersonCount());
            pr.setInt(7, product.getProductionWorkshopNumber());
            pr.setInt(8, product.getMinCostForAgent());
            pr.setInt(9, product.getID());

            pr.executeUpdate();
        }
    }

    public static List<Product> selectall() throws SQLException {
        try (Connection c = App.getConnection()) {
            String sql = "SELECT * FROM Product";
            Statement statement = c.createStatement();
            statement.executeQuery(sql);

            List list = new ArrayList<>();

            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                list.add(new Product(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getInt(7),
                        resultSet.getInt(8),
                        resultSet.getInt(9)));
            }
            return list;
        }
    }

    public static void deletebyid(int id) throws SQLException {
        try (Connection c = App.getConnection()) {
            String sql = "DELETE FROM Product WHERE ID=?";
            PreparedStatement pr = c.prepareStatement(sql);

            pr.setInt(1, id);
            pr.executeUpdate();
        }
    }

    public static void delete(Product product) throws SQLException {
        deletebyid(product.getID());
    }
}
