package com.huyvn.happytostudy.model.common;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by thuynghi on 15/01/2016.
 */
public class GenericModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private ObjectId id;

    protected Date createDate;

    protected Date modifiedDate;

    public ObjectId getId() {
        return id;
    }

    public GenericModel(Date createDate, Date modifiedDate) {
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public GenericModel() {
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
