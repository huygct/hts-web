package com.huyvn.happytostudy.services;

import com.huyvn.happytostudy.model.UserModel;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * Created by Huy Nghi on 9/17/2015.
 */
public interface UserService extends UserDetailsService{
    List<UserModel> findAll();
    UserModel findByEmail(String email);
    void addUser(UserModel user);
}
