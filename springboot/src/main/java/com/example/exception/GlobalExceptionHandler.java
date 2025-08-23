package com.example.exception;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.example.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理类，负责捕获并处理应用中的各种异常。
 * 使用@ControllerAdvice注解，拦截指定包下的所有控制器抛出的异常。
 */
@ControllerAdvice(basePackages = "com.example.controller")
public class GlobalExceptionHandler {

    /** 日志记录器，用于记录异常信息 */
    private static final Log log = LogFactory.get();

    /**
     * 处理通用的异常情况，如NullPointerException、ArrayIndexOutOfBoundsException等。
     * @param request 请求信息
     * @param e 捕获的异常
     * @return 统一格式的错误响应
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody // 返回JSON格式的响应
    public Result handleGeneralError(HttpServletRequest request, Exception e) {
        log.error("捕获到通用异常：", e);
        return Result.error(); // 返回默认的错误信息
    }

    /**
     * 处理自定义异常CustomException。
     * @param request 请求信息
     * @param e 捕获的自定义异常
     * @return 包含错误码和错误信息的响应
     */
    @ExceptionHandler(CustomException.class)
    @ResponseBody // 返回JSON格式的响应
    public Result handleCustomError(HttpServletRequest request, CustomException e) {
        // 返回包含自定义错误码和错误信息的错误响应
        return Result.error(e.getCode(), e.getMsg());
    }
}
