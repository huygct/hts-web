package com.huyvn.happytostudy.repositories;

import com.huyvn.happytostudy.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.persistence.NoResultException;

/**
 * Created by Huy Nghi on 9/17/2015.
 */
public interface UserRepository extends MyBaseRepository<UserModel, String> {
    public UserModel findByEmail(String email);
    public UserModel findByName(String username) throws NoResultException;
}
