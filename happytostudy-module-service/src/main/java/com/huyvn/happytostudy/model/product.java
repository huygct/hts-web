package com.huyvn.happytostudy.model;

import com.huyvn.happytostudy.model.common.GenericModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


/**
 * Created by Knightzoro on 1/12/16.
 */
@Document(collection = "Product")
public class Product extends GenericModel {

    private String name;
    private float cost;
    private float sale;
    private String trademark;
    private String promotion;
    private int kind;
    private int style;
    private String description;
    private int quantity;
    private List<ObjectId> idCategory;
    private List<ObjectId> idPromotionProgram;

    public Product() {

    }

    public Product(String name, float cost, float sale, String trademark, String promotion, int kind, int style, String description, int quantity, List<ObjectId> idCategory, List<ObjectId> idPromotionProgram) {
        this.name = name;
        this.cost = cost;
        this.sale = sale;
        this.trademark = trademark;
        this.promotion = promotion;
        this.kind = kind;
        this.style = style;
        this.description = description;
        this.quantity = quantity;
        this.idCategory = idCategory;
        this.idPromotionProgram = idPromotionProgram;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getSale() {
        return sale;
    }

    public void setSale(float sale) {
        this.sale = sale;
    }

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<ObjectId> getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(List<ObjectId> idCategory) {
        this.idCategory = idCategory;
    }

    public List<ObjectId> getIdPromotionProgram() {
        return idPromotionProgram;
    }

    public void setIdPromotionProgram(List<ObjectId> idPromotionProgram) {
        this.idPromotionProgram = idPromotionProgram;
    }
}
