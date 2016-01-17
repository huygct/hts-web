package com.huyvn.happytostudy.services;

import com.huyvn.happytostudy.model.Category;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * Created by Knightzoro on 1/16/16.
 */
public interface CategoryService {
    List<Category> findAll();
    Category findByName(String name);
    Category findOne(ObjectId id);
    Category add (Category category);
    Category update (Category category);
    void delete (Category category);
}
