package com.panyu.marketclient.base;

import com.panyu.marketclient.enums.MarketResultCodeEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class MarketBaseResponse<T> implements Serializable {


    private int code;

    private String message;

    private String errorCode;

    private T data;

    public MarketBaseResponse() {
    }

    public MarketBaseResponse(MarketResultCodeEnum resultCodeEnum) {
        this.code = resultCodeEnum.code;
        this.message = resultCodeEnum.message;
    }

    public MarketBaseResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public void set(MarketResultCodeEnum resultCodeEnum) {
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

