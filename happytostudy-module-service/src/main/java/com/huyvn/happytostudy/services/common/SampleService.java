package com.huyvn.happytostudy.services.common;

import com.huyvn.happytostudy.model.common.SampleResponse;
import org.springframework.stereotype.Service;

@Service
public class SampleService {
    public SampleResponse sayHello(String message) {
        return new SampleResponse("hello " + message, "SUCCESS");
    }
}