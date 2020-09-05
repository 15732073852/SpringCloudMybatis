package com.panyu.client.enums;

public enum CheckCouponResultCodeEnum {

    SUCCESS(0 ,"成功"),
    FAIL(1,"失败"),
    SERVER_EXCEPTION(2, "服务器发送异常，请稍后再试！");
//    SUCCESS(0, "成功"),
//    FAIL(1, "失败"),
//    SERVER_EXCEPTION(2, "服务器发送异常，请稍后再试！");


    public int code;
    public  String message;

    CheckCouponResultCodeEnum(int code, String message){
        this.code = code;
        this.message = message;
    }
}
