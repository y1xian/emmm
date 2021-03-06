package com.yyxnb.amazing.bean;

import com.yyxnb.common.interfaces.IData;

import java.io.Serializable;

public class BaseData<T> implements IData<T>, Serializable {

    public String status;
    public String message;
    public T data;

    @Override
    public String getCode() {
        return status;
    }

//    public void setCode(int code) {
//        this.code = code;
//    }

    @Override
    public String getMsg() {
        return message;
    }

    @Override
    public T getResult() {
        return data;
    }

    @Override
    public boolean isSuccess() {
        return "200".equals(status);
    }

//    public void setMsg(String msg) {
//        this.msg = msg;
//    }

//    public T getData() {
//        return data;
//    }

//    public void setData(T data) {
//        this.data = data;
//    }
}
