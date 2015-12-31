package com.huyvn.happytostudy.controllers;

import com.huyvn.happytostudy.model.SampleResponse;
import com.huyvn.happytostudy.model.UserModel;
import com.huyvn.happytostudy.services.SampleService;
import com.huyvn.happytostudy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/hello/{message}", method = RequestMethod.GET)
    public @ResponseBody
    SampleResponse sayHello(@PathVariable String message) {
        return sampleService.sayHello(message);
    }

    @RequestMapping(value = "/userList", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody
    List<UserModel> listUsersJson() {

        UserModel userUser = new UserModel("user", passwordEncoder.encode("user"));
        userUser.addRole("user");
        userService.addUser(userUser);

        UserModel adminUser = new UserModel("admin", passwordEncoder.encode("admin"));
        adminUser.addRole("user");
        adminUser.addRole("admin");
        userService.addUser(adminUser);

        return userService.findAll();
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST, headers = "Accept=application/json")
    public
    void addUser() {
//        UserModel user = new UserModel("admin", "admin");

//        userService.addUser(user);
    }
}
