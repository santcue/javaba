package cue.edu.co.model;

import cue.edu.co.Singleton.DatabaseConnection;
import lombok.*;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Product {

    private String id;
    private String name;
    private double price;
    private LocalDateTime registrationDate;

    private Product createProduct(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setId(resultSet.getString("id"));
        product.setName(resultSet.getString("name"));
        product.setPrice(resultSet.getDouble("price"));
        product.setRegistrationDate(
                resultSet.getDate("registration_date") != null ?
                        resultSet.getDate("registration_date")
                                .toInstant()
                                .atZone(ZoneId.systemDefault())
                                .toLocalDateTime() : null);
        return product;
    }

    public List<Product> list() {
        List<Product> products = new ArrayList<Product>();
        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM product")) {
            while (resultSet.next()) {
                Product product = createProduct(resultSet);
                products.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public Product byId(int id) {
        Product product = null;
        try (PreparedStatement preparedStatement = getConnection()
                .prepareStatement("SELECT * FROM product WHERE id = ?")) {
            preparedStatement.setLong(1, id);
            ResultSet resultset = preparedStatement.executeQuery();
            if (resultset.next()) {
                product = createProduct(resultset);
            }
            resultset.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    private Connection getConnection() throws SQLException {
        return DatabaseConnection.getInstance();
    }

}
