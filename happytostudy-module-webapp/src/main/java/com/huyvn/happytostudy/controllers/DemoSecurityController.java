package com.huyvn.happytostudy.controllers;

import com.huyvn.happytostudy.model.common.SampleResponse;
import com.huyvn.happytostudy.services.common.SampleService;
import com.huyvn.happytostudy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Huy Nghi on 9/19/2015.
 */
@Controller
@RequestMapping(value = "/protected/demo")
public class DemoSecurityController {

    @Autowired
    private SampleService sampleService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/hello/{message}", method = RequestMethod.GET)
    public @ResponseBody
    SampleResponse sayHello(@PathVariable String message) {
        return sampleService.sayHello(message);
    }

}
