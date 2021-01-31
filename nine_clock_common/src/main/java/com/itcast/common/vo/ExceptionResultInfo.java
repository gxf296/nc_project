package com.itcast.common.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.itcast.common.enums.ResponseEnum;
import lombok.Data;

/**
 * @version v1.0.0
 * @belongsProject: nine_clock_project
 * @belongsPackage: com.itcast.common.vo
 * @author: 戈向峰
 * @description: 服务端提供前端返回的结果
 * @createTime: 2021-01-30 10:49
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExceptionResultInfo<T> {
    //是否成功
    private Boolean success;
    //返回状态码
    private int code;
    //提示消息
    private String message;
    //返回数据 可能是对象 集合 普通类型
    private T data;

    public ExceptionResultInfo() {
    }

    private ExceptionResultInfo(Boolean success, int code) {
        this.success = success;
        this.code = code;
    }

    private ExceptionResultInfo(Boolean success, int code, T data) {
        this.success = success;
        this.code = code;
        this.data = data;
    }

    public ExceptionResultInfo(Boolean success, int code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ExceptionResultInfo(Boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
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

    public static <T> ExceptionResultInfo<T> success() {
        return new ExceptionResultInfo<T>(true, ResponseEnum.SUCCESS.getCode());
    }

    public static <T> ExceptionResultInfo<T> successMessage(String message) {
        return new ExceptionResultInfo<T>(true, ResponseEnum.SUCCESS.getCode(), message);
    }

    public static <T> ExceptionResultInfo<T> success(T data) {
        return new ExceptionResultInfo<T>(true, ResponseEnum.SUCCESS.getCode(), data);
    }

    public static <T> ExceptionResultInfo<T> success(String message, T data) {
        return new ExceptionResultInfo<T>(true, ResponseEnum.SUCCESS.getCode(), message, data);
    }

    public static <T> ExceptionResultInfo<T> error() {
        return new ExceptionResultInfo<T>(false, ResponseEnum.ERROR.getCode(), ResponseEnum.ERROR.getMessage());
    }

    public static <T> ExceptionResultInfo<T> errorMessage(String errorMessage) {
        return new ExceptionResultInfo<T>(false, ResponseEnum.ERROR.getCode(), errorMessage);
    }

    public static <T> ExceptionResultInfo<T> errorCodeMessage(int errorCode, String errorMessage) {
        return new ExceptionResultInfo<T>(false, errorCode, errorMessage);
    }
}
