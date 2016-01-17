package com.huyvn.happytostudy.model;

import com.huyvn.happytostudy.model.common.GenericModel;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Knightzoro on 1/12/16.
 */
@Document(collection = "Category")
public class Category extends GenericModel {
    private String name;

    public Category () {

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

}
