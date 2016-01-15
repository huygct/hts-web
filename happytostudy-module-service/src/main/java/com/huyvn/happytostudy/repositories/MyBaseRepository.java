package com.huyvn.happytostudy.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by thuynghi on 15/01/2016.
 */
@NoRepositoryBean
public interface MyBaseRepository<T, ID extends Serializable> extends MongoRepository<T, ID> {
//    public List<T> findAll();
}
