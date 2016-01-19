package com.huyvn.happytostudy.controllers;

import com.huyvn.happytostudy.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by thuynghi on 19/01/2016.
 */
@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    ProductService productService;



}
