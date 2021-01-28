package com.ns.springcloud.entities;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author : Nsz
 * @version :1.0
 * @email : 954062058@qq.com
 * @since : 2021-01-27 9:35
 */
@Data
@AllArgsConstructor //全参数
@NoArgsConstructor //空参数
public class CommonResult <T> implements Serializable {   //泛型T表示通用
    private static final long serialVersionUID = 1L;

    /**
     * 成功
     */
    public static final int SUCCESS = 200;
    public static final String SUCCESS_MESSAGE = "操作成功";
    /**
     * 错误
     */
    public static final int ERROR = 999;
    public static final String ERROR_MESSAGE = "操作失败";
    /**
     * 状态码
     */
    private int code;

    /**
     * 返回内容
     */
    private String message;

    /**
     * 数据对象
     */
    private T data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }


    public static <T> CommonResult<T> success() {
        return success (SUCCESS, SUCCESS_MESSAGE, (T) null);
    }

    public static <T> CommonResult<T> success(String message) {
        return success (SUCCESS, message, (T) null);
    }

    public static <T> CommonResult<T> success(T obj) {
        return success (SUCCESS, SUCCESS_MESSAGE, obj);
    }

    public static <T> CommonResult<T> success(String message, T obj) {
        return success (SUCCESS, message, obj);
    }

    public static <T> CommonResult<T> success(int code, String message, T obj) {
        return new CommonResult<T> (code, message, obj);
    }


    public static <T> CommonResult<T> error() {
        return error (ERROR, ERROR_MESSAGE, (T) null);
    }

    public static <T> CommonResult<T> error(int code) {
        return error (code, ERROR_MESSAGE, (T) null);
    }

    public static <T> CommonResult<T> error(String message) {
        return error (ERROR, message, (T) null);
    }

    public static <T> CommonResult<T> error(String message, T object){ return error(ERROR, message, object);};

    public static <T> CommonResult<T> error(T obj) {
        return error (ERROR, ERROR_MESSAGE, obj);
    }

    public static <T> CommonResult<T> error(int code, String message) {
        return error (code, message, (T) null);
    }

    public static <T> CommonResult<T> error(int code, T obj) {
        return error (code, ERROR_MESSAGE, obj);
    }

    public static <T> CommonResult<T> error(int code, String message, T obj) {
        return new CommonResult<T> (code, message, obj);
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


    @Override
    public String toString() {
        return JSON.toJSONString (this);
    }
}
