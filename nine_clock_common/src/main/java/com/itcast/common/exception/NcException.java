package com.itcast.common.exception;

import com.itcast.common.enums.ResponseEnum;
import lombok.Data;

/**
 * @version v1.0.0
 * @belongsProject: nine_clock_project
 * @belongsPackage: com.itcast.common.ex
 * @author: 戈向峰
 * @description: 自定义异常
 * @createTime: 2021-01-30 18:55
 */
@Data
public class NcException extends RuntimeException {
    private int code;

    public NcException(int code) {
        this.code = code;
    }

    public NcException(int code, String message) {
        super(message);
        this.code = code;
    }

    public NcException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }

    public NcException(Throwable cause, int code) {
        super(cause);
        this.code = code;
    }

    public NcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }

    public NcException(ResponseEnum enums) {
        super(enums.getMessage());
        this.code = enums.getCode();
    }
}
