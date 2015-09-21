package com.huyvn.happytostudy.services;

import com.huyvn.happytostudy.model.SampleResponse;
import org.springframework.stereotype.Service;

@Service
public class SampleService {
    public SampleResponse sayHello(String message) {
        return new SampleResponse("hello " + message, "SUCCESS");
    }
}