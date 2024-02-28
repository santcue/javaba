package cue.edu.co;

import cue.edu.co.Interface.ProductImpl;
import cue.edu.co.Singleton.DatabaseConnection;

import java.sql.*;
public class Main2 {
    public static void main(String[] args) {
      try {Connection connection = DatabaseConnection.getInstance();
          Repository<Product> repository = new ProductImpl();
          System.out.println("*** List porducts from database");
          repository.list().stream().forEach(System.out::println);
          System.out.println("*** Get by Id: 1 ");
          System.out.println(repository.ById(1).toString());



       } catch (SQLException e){
               e.printStackTrace();
    }
}
