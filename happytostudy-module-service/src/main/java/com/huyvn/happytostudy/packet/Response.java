package com.huyvn.happytostudy.packet;

import java.util.List;

/**
 * Created by Zoro on 15/01/2016.
 */
public class Response<T> {
    private int code;
    private List<T> data;
    private String message;

    public Response() {
    }

    public Response(int code, List<T> data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
