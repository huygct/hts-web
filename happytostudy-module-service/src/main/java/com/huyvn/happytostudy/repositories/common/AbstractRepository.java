package com.huyvn.happytostudy.repositories.common;

import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by Knightzoro on 1/16/16.
 */
public class AbstractRepository<T> {

    private Class<T> clazz;

    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }

    protected MongoTemplate mongoTemplate;

    public T add(T t) {
        mongoTemplate.insert(t);
        return t;
    }

    public void remove (T t) {
        mongoTemplate.remove(t);
    }

}
