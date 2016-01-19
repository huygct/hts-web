package com.huyvn.happytostudy.model;

import com.huyvn.happytostudy.model.common.GenericModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Knightzoro on 1/12/16.
 */
@Document(collection = "Category")
public class Category extends GenericModel {
    private String name;
    private List<ObjectId> productIdList;

    public Category () {
        this.name = "";
        this.productIdList = new ArrayList<ObjectId>();
    }

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ObjectId> getProductIdList() {
        return productIdList;
    }

    public void setProductIdList(List<ObjectId> productIdList) {
        this.productIdList = productIdList;
    }
}
