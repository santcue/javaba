package cue.edu.co;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "root123";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement =  connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM product");
            ) {
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id"));
                System.out.print("|");
                System.out.println(resultSet.getString("name"));
                System.out.print("|");
                System.out.println(resultSet.getString("price"));
                System.out.print("|");
                System.out.println(resultSet.getString("registration_date"));
            }
        } catch (SQLException e){
                e.printStackTrace();
        }
    }

}
