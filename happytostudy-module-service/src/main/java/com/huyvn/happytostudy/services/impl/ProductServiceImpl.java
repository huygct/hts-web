package com.huyvn.happytostudy.services.impl;

import com.huyvn.happytostudy.model.Product;
import com.huyvn.happytostudy.repositories.ProductRepository;
import com.huyvn.happytostudy.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Knightzoro on 1/16/16.
 */
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Product add(Product category) {
        return null;
    }

    @Override
    public Product update(Product category) {
        return null;
    }

    @Override
    public void delete(Product category) {

    }
}
