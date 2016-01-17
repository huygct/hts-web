package com.huyvn.happytostudy.controllers;

import com.huyvn.happytostudy.model.Category;
import com.huyvn.happytostudy.packet.Response;
import com.huyvn.happytostudy.packet.ResponseMessage;
import com.huyvn.happytostudy.packet.StatusCode;
import com.huyvn.happytostudy.services.CategoryService;
import org.bson.types.ObjectId;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Knightzoro on 1/16/16.
 */
@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    /**
     *
     * @return
     */
    @RequestMapping(value = "/getList", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody
    Response<Category> getCategories () {
        List<Category> categoryList = categoryService.findAll();
        Response<Category> response = new Response<Category>();

        if(!categoryList.isEmpty()) {
            response.setCode(StatusCode.CODE_200);
            response.setData(categoryList);
            response.setMessage(ResponseMessage.SUCCESS_MESSAGE);
        } else {
            response.setCode(StatusCode.CODE_200);
            response.setData(categoryList);
            response.setMessage(ResponseMessage.SUCCESS_MESSAGE);
        }

        return response;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, headers = "Accept=application/json")
    public @ResponseBody
    Response<Category> addCategory (@RequestBody String categoryJson) {
        Response<Category> response = new Response<Category>();
        Category category = new Category();
        try {
            JSONObject json = new JSONObject(categoryJson);
            category.setName(json.getString("name"));
            if (categoryService.add(category) != null) {
                response.setCode(StatusCode.CODE_201);
                response.setMessage(ResponseMessage.SUCCESS_MESSAGE);
            } else {
                response.setCode(StatusCode.CODE_400);
                response.setMessage(ResponseMessage.NOT_EXIST_MESSAGE);
            }
        } catch (JSONException e) {
            response.setCode(StatusCode.CODE_400);
            response.setMessage(ResponseMessage.FAIL_MESSAGE);
            e.printStackTrace();
        }

        return response;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, headers = "Accept=application/json")
    public @ResponseBody
    Response<Category> updateCategory (@RequestBody String categoryJson) {
        Response<Category> response = new Response<Category>();
        Category category;
        try {
            JSONObject json = new JSONObject(categoryJson);
            String idCategory = json.getString("id");
            String nameCategory = json.getString("name");
            ObjectId id = new ObjectId(idCategory);
            category = categoryService.findOne(id);

            if (category != null) {
                category.setName(nameCategory);
                categoryService.update(category);
                response.setCode(StatusCode.CODE_201);
                response.setMessage(ResponseMessage.SUCCESS_MESSAGE);

            } else {
                response.setCode(StatusCode.CODE_404);
                response.setMessage(ResponseMessage.NOT_EXIST_MESSAGE);
            }
        } catch (JSONException e) {
            response.setCode(StatusCode.CODE_400);
            response.setMessage(ResponseMessage.FAIL_MESSAGE);
            e.printStackTrace();
        }

        return response;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public @ResponseBody
    Response<Category> deleteCategory (@RequestBody String categoryJson) {
        Response<Category> response = new Response<Category>();
        Category category;
        try {
            JSONObject json = new JSONObject(categoryJson);
            String idCategory = json.getString("id");
            ObjectId id = new ObjectId(idCategory);
            category = categoryService.findOne(id);
            if (category != null) {
                categoryService.delete(category);
                response.setCode(StatusCode.CODE_201);
                response.setMessage(ResponseMessage.SUCCESS_MESSAGE);
            } else {
                response.setCode(StatusCode.CODE_404);
                response.setMessage(ResponseMessage.NOT_EXIST_MESSAGE);
            }
        } catch (JSONException e) {
            response.setCode(StatusCode.CODE_400);
            response.setMessage(ResponseMessage.FAIL_MESSAGE);
            e.printStackTrace();
        }

        return response;
    }
}
