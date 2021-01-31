package com.itcast.common.exception.advice;

import com.itcast.common.exception.NcException;
import com.itcast.common.vo.ExceptionResultInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @version v1.0.0
 * @belongsProject: nine_clock_project
 * @belongsPackage: com.itcast.common.exception.advice
 * @author: 戈向峰
 * @description: 统一异常处理类
 * @createTime: 2021-01-30 18:44
 */
@Slf4j
@ResponseBody
@ControllerAdvice
public class BasicExceptionAdvice {
    /**
     * 自定义处理异常
     * @param e
     * @return
     */
    @ExceptionHandler(NcException.class)
    public ExceptionResultInfo handleException(NcException e){
        return new ExceptionResultInfo(false,e.getCode(),e.getMessage());
    }

    /**
     * 处理运行时异常
     * @param e
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public ExceptionResultInfo handleException(RuntimeException e) {
        // 我们暂定返回状态码为400， 然后从异常中获取友好提示信息
        return new ExceptionResultInfo(false, 400, e.getMessage());
    }

    /**
     * 处理运行时异常
     * @param exception
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ExceptionResultInfo handlerNcException(Exception exception){
        return new ExceptionResultInfo(false, 500, exception.getMessage());
    }
}
