package com.huyvn.happytostudy.services.impl;

import com.huyvn.happytostudy.model.Category;
import com.huyvn.happytostudy.repositories.CategoryRepository;
import com.huyvn.happytostudy.services.CategoryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Knightzoro on 1/16/16.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findOne(ObjectId id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public Category add(Category category) {
        return categoryRepository.insert(category);
    }

    @Override
    public Category update(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void delete(Category category) {
         categoryRepository.delete(category.getId());
    }
}
