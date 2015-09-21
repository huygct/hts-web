package com.huyvn.happytostudy.services;

import com.huyvn.happytostudy.model.UserModel;
import com.huyvn.happytostudy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Huy Nghi on 9/17/2015.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserModel findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void addUser() {
//        User user = new User("aaaa", "bbb", "ccc", "ddd");
//        userRepository.save(user);

//        double age = Math.ceil(Math.random() * 100);
//        Person p = new Person("nnnnnnnnnnnnn", (int) age);

//        mongoTemplate.insert(p);
    }
}
