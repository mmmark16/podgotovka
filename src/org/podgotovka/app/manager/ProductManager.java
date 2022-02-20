package org.podgotovka.app.manager;

import org.podgotovka.app.App;
import org.podgotovka.app.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    public static void insert(Product product) throws SQLException {
        try(Connection c = App.getConnection()){
            String sql = "INSERT INTO PRODUCT (Title, ProductType, ArticleNumber, Description, Image, ProductionPersonCount, ProductionWorkshopNumber, MinCostForAgent) VALUES(?,?,?,?,?,?,?,?)";
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
            if (keys.next()){
                product.setId(keys.getInt(1));
                return;
            }
            throw new SQLException("ошибка генерации ключа");
        }
    }

    public static void update(Product product) throws SQLException {
        try(Connection c = App.getConnection()){
            String sql = "UPDATE PRODUCT SET Title=?, ProductType=?, ArticleNumber=?, Description=?, Image=?, ProductionPersonCount=?, ProductionWorkshopNumber=?, MinCostForAgent=? WHERE ID =?";
            PreparedStatement pr = c.prepareStatement(sql);

            pr.setString(1, product.getTitle());
            pr.setString(2, product.getProductType());
            pr.setInt(3, product.getArticleNumber());
            pr.setString(4, product.getDescription());
            pr.setString(5, product.getImage());
            pr.setInt(6, product.getProductionPersonCount());
            pr.setInt(7, product.getProductionWorkshopNumber());
            pr.setInt(8, product.getMinCostForAgent());
            pr.setInt(9, product.getId());

            pr.executeUpdate();
        }
    }

    public static Product selectById(int id) throws SQLException {
        try(Connection c = App.getConnection()){
            String sql = "SELECT * FROM PRODUCT WHERE ID =?";
            PreparedStatement pr = c.prepareStatement(sql);
            pr.setInt(1, id);

            ResultSet resultSet = pr.executeQuery();

            if(resultSet.next()){
                return new Product(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getInt(7),
                        resultSet.getInt(8),
                        resultSet.getInt(9)
                        );
            }
        }
        return  null;
    }

    public static List<Product> selectAll() throws SQLException {
        try(Connection c = App.getConnection()){
            String sql = "SELECT * FROM PRODUCT";
            Statement statement = c.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            List<Product> list = new ArrayList<>();

            while(resultSet.next()){
                list.add( new Product(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getInt(7),
                        resultSet.getInt(8),
                        resultSet.getInt(9)
                ));
            }
            return list;
        }
    }

    public static void deleteById(int id) throws SQLException {
        try (Connection c = App.getConnection()) {
            String sql = "DELETE FROM PRODUCT WHERE ID =?";
            PreparedStatement pr = c.prepareStatement(sql);
            pr.setInt(1, id);

            pr.executeUpdate();
        }
    }

    public static void delete(Product product) throws SQLException {
        deleteById(product.getId());
    }
}
