package cue.edu.co.Interface;

import cue.edu.co.Singleton.DatabaseConnection;
import cue.edu.co.model.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProductImpl implements Interface<Product> {

    private Connection getConnection() throws SQLException {
        return DatabaseConnection.getInstance();
    }

    @Override
    public List<Product> list() {
        return null;
    }

    @Override
    public Product byId(long id) {
        return null;
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void delete(long id) {

    }
}
