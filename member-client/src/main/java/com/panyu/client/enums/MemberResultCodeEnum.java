package com.panyu.client.enums;

/**
 *
 * 功能描述:client响应结果代码
 *
 */
public enum MemberResultCodeEnum {

       SUCCESS(0, "成功"),
    FAIL(1, "失败"),
    SERVER_EXCEPTION(2, "服务器发送异常，请稍后再试！");

    public int code;
    public String message;

    MemberResultCodeEnum(int code, String message){
        this.code = code;
        this.message = message;
    }
}
