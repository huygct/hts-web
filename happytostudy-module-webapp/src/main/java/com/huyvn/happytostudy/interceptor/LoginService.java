//package com.huyvn.happytostudy.interceptor;
//
//import com.huyvn.happytostudy.model.UserModel;
//import com.huyvn.happytostudy.services.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Arrays;
//import java.util.List;
//
///**
// * Created by Huy Nghi on 9/19/2015.
// */
//@Service
//public class LoginService implements UserDetailsService
//{
//    @Autowired
//    private UserService userService;
//
//    public UserDetails loadUserByUsername( String email ) throws UsernameNotFoundException
//    {
//        UserModel user = userService.findByEmail(email);
//
//        if( user == null )
//            throw new UsernameNotFoundException( "Oops!" );
//
//        List<SimpleGrantedAuthority> authorities = Arrays.asList( new SimpleGrantedAuthority( user.getRole().toString() ) );
//
//        return new User( user.getEmail(), user.getPassword(), authorities );
//    }
//}