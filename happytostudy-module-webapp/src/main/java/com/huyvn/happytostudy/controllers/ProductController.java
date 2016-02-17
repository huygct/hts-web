package com.huyvn.happytostudy.controllers;

import com.huyvn.happytostudy.model.Product;
import com.huyvn.happytostudy.packet.Response;
import com.huyvn.happytostudy.packet.ResponseMessage;
import com.huyvn.happytostudy.packet.StatusCode;
import com.huyvn.happytostudy.services.ProductService;
import org.bson.types.ObjectId;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thuynghi on 19/01/2016.
 */
@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    ProductService productService;

    /**
     * 
     */
    @RequestMapping(value = "/getList", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody
    Response<Product> getProducts () {
        List<Product> productList = productService.findAll();
        Response<Product> response = new Response<Product>();

        if(!productList.isEmpty()) {
            response.setCode(StatusCode.CODE_200);
            response.setData(productList);
            response.setMessage(ResponseMessage.SUCCESS_MESSAGE);
        } else {
            response.setCode(StatusCode.CODE_200);
            response.setData(productList);
            response.setMessage(ResponseMessage.SUCCESS_MESSAGE);
        }

        return response;
    }

    /**
     * 
     * @param productJson
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST, headers = "Accept=application/json")
    public @ResponseBody
    Response<Product> addProduct (@RequestBody String productJson) {
        Response<Product> response = new Response<Product>();
        Product product = new Product();
        List<ObjectId> categoryIdList = new ArrayList<ObjectId>();
        List<ObjectId> promotionProgramIdList = new ArrayList<ObjectId>();

        try {
            JSONObject json = new JSONObject(productJson);
            product.setName(json.getString("name"));
            product.setCost(Float.valueOf(json.getString("cost")));
            product.setSale(Float.valueOf(json.getString("sale")));
            product.setTrademark(json.getString("trademark"));
            product.setPromotion(json.getString("promotion"));
            product.setKind(json.getInt("kind"));
            product.setStyle(json.getInt("style"));
            product.setDescription(json.getString("description"));
            product.setQuantity(json.getInt("quantity"));

            categoryIdList.add(new ObjectId(json.getString("idCategory")));
            product.setIdCategory(categoryIdList);

            promotionProgramIdList.add(new ObjectId(json.getString("idPromotionProgram")));
            product.setIdPromotionProgram(promotionProgramIdList);


            if (productService.add(product) != null) {
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

    /**
     *
     * @param productJson
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT, headers = "Accept=application/json")
    public @ResponseBody
    Response<Product> updateProduct (@RequestBody String productJson) {
        Response<Product> response = new Response<Product>();
        List<ObjectId> categoryIdList = new ArrayList<ObjectId>();
        List<ObjectId> promotionProgramIdList = new ArrayList<ObjectId>();
        Product product;
        try {
            JSONObject json = new JSONObject(productJson);
            String idProduct = json.getString("id");

            ObjectId id = new ObjectId(idProduct);
            product = productService.findOne(id);

            if (product != null) {
                product.setName(json.getString("name"));
                product.setCost(Float.valueOf(json.getString("cost")));
                product.setSale(Float.valueOf(json.getString("sale")));
                product.setTrademark(json.getString("trademark"));
                product.setPromotion(json.getString("promotion"));
                product.setKind(json.getInt("kind"));
                product.setStyle(json.getInt("style"));
                product.setDescription(json.getString("description"));
                product.setQuantity(json.getInt("quantity"));

                categoryIdList.add(new ObjectId(json.getString("idCategory")));
                product.setIdCategory(categoryIdList);

                promotionProgramIdList.add(new ObjectId(json.getString("idPromotionProgram")));
                product.setIdPromotionProgram(promotionProgramIdList);

                productService.update(product);
                
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

    /**
     * 
     * @param productJson
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public @ResponseBody
    Response<Product> deleteProduct (@RequestBody String productJson) {
        Response<Product> response = new Response<Product>();
        Product product;
        try {
            JSONObject json = new JSONObject(productJson);
            String idProduct = json.getString("id");
            ObjectId id = new ObjectId(idProduct);
            product = productService.findOne(id);
            if (product != null) {
                productService.delete(product);
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
