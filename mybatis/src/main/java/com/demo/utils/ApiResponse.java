package com.demo.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * 通用接口数据返回
 */

public class ApiResponse<T> implements Serializable {

    /**
     * serialVersionUID适用于java序列化机制。
     * 简单来说，JAVA序列化的机制是通过判断类的serialVersionUID来验证的版本一致的。
     * 在进行反序列化时，JVM会把传来的字节流中的serialVersionUID于本地相应实体类的serialVersionUID进行比较。
     * 如果相同说明是一致的，可以进行反序列化，否则会出现反序列化版本一致的异常，即是InvalidCastException
     */
    private static final long serialVersionUID = 9211889136173018364L;

    /**
     * 正常响应码
     */
    private static final int SUCCESS_CODE = 0;

    /**
     * 正常响应消息
     */
    private static final String SUCCESS_MSG = "SUCCESS";

    /**
     * 错误码
     */
    private int code = SUCCESS_CODE;

    /**
     * 错误信息
     */
    private String msg = SUCCESS_MSG;

    /**
     * 响应内容，默认为null
     */
    private T data = null;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 是否的正常响应
     *
     * @return true=正常；false=异常
     */
    @JsonIgnore
    public boolean isOK() {
        return code == SUCCESS_CODE;
    }

    /**
     * 无data的正常返回
     */
    public static ApiResponse retOK() {
        return new ApiResponse();
    }

    /**
     * 有data的正常返回
     *
     * @param data data内容
     * @param <T> data类型
     */
    public static <T> ApiResponse<T> retOK(T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setData(data);
        return response;
    }

    /**
     * 无data的失败返回
     *
     * @param code 错误码
     * @param msg 错误信息
     */
    public static <T> ApiResponse<T> retFail(int code, String msg) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }

    /**
     * 有data的失败返回
     * <br>
     * 失败返回的场景不多，所以没有严格要求T泛型
     *
     * @param code 错误码
     * @param msg 错误信息
     */
    public static <T> ApiResponse<T> retFail(int code, String msg, T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setCode(code);
        response.setMsg(msg);
        response.setData(data);
        return response;
    }

}
