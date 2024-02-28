package cue.edu.co;

import cue.edu.co.Interface.Interface;
import cue.edu.co.Interface.impl.ProductImpl;
import cue.edu.co.Singleton.DatabaseConnection;
import cue.edu.co.model.Product;

import java.sql.*;
public class Main2 {
    public static void main(String[] args) {
      try {Connection connection = DatabaseConnection.getInstance();
          Interface<Product> product = new ProductImpl();
          System.out.println("*** List products from database");
          product.list().forEach(System.out::println);
          System.out.println("*** Get by Id: 1 ");
          System.out.println(product.byId(1).toString());

      } catch (SQLException e) {
          e.printStackTrace();
      }
    }
}
