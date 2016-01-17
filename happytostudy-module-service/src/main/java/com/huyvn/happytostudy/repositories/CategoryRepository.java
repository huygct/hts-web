package com.huyvn.happytostudy.repositories;

import com.huyvn.happytostudy.model.Category;
import com.huyvn.happytostudy.repositories.myRepository.MyBaseRepository;
import org.bson.types.ObjectId;

/**
 * Created by Knightzoro on 1/16/16.
 */
public interface CategoryRepository extends MyBaseRepository<Category, ObjectId> {
    Category findByName(String name);
}
