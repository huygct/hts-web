package com.huyvn.happytostudy.services;

import com.huyvn.happytostudy.model.Product;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * Created by Knightzoro on 1/16/16.
 */
public interface ProductService {
    List<Product> findAll();
    Product findOne(ObjectId id);
    Product add (Product category);
    Product update (Product category);
    void delete (Product category);
}
