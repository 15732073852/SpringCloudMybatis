package com.panyu.shopweb.base;

import com.panyu.shopweb.enums.WebResultCodeEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class WebBaseResponse<T> implements Serializable {


    private int code;

    private String message;

    private String errorCode;

    private T data;

    public WebBaseResponse() {
    }

    public WebBaseResponse(WebResultCodeEnum resultCodeEnum) {
        this.code = resultCodeEnum.code;
        this.message = resultCodeEnum.message;
    }

    public WebBaseResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public void set(WebResultCodeEnum resultCodeEnum) {
        this.code = resultCodeEnum.code;
        this.message = resultCodeEnum.message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}

