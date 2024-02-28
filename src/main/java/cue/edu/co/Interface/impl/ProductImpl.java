package cue.edu.co.Interface.impl;

import cue.edu.co.Interface.Interface;
import cue.edu.co.model.Product;

import java.util.List;

public class ProductImpl implements Interface<Product> {

    @Override
    public List<Product> list() {
        Product product = new Product();
        return product.list();
    }

    @Override
    public Product byId(long id) {
        Product product = new Product();
        return product.byId((int) id);
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void delete(long id) {

    }
}
