package com.huyvn.happytostudy.repositories;

import com.huyvn.happytostudy.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Huy Nghi on 9/17/2015.
 */
public interface UserRepository extends MongoRepository<UserModel, String> {
    public UserModel findByEmail(String email);
}
