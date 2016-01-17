package com.huyvn.happytostudy.model;

import com.huyvn.happytostudy.model.common.GenericModel;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Knightzoro on 1/12/16.
 */
@Document(collection = "PromotionProgram")
public class PromotionProgram extends GenericModel {

    private String name;

    public PromotionProgram() {

    }

    public PromotionProgram(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
