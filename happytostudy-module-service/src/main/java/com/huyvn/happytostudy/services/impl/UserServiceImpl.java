package com.huyvn.happytostudy.services.impl;

import com.huyvn.happytostudy.model.UserModel;
import com.huyvn.happytostudy.repositories.UserRepository;
import com.huyvn.happytostudy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Huy Nghi on 9/17/2015.
 */
@Service("userService")
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
    public void addUser(UserModel user) {
//        User user = new User("aaaa", "bbb", "ccc", "ddd");
        userRepository.save(user);

//        double age = Math.ceil(Math.random() * 100);
//        Person p = new Person("nnnnnnnnnnnnn", (int) age);

//        mongoTemplate.insert(p);
    }

    @Override
    public UserDetails loadUserByUsername(String username)  {
        UserModel user = null;

        user = userRepository.findByName(username);
        if (user == null || user.getId() == null){
            throw new UsernameNotFoundException("User does not found");
        }

        return user;
    }
}
