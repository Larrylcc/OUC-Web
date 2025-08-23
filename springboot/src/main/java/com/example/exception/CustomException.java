package com.example.exception;

import com.example.common.enums.ResultCodeEnum;

/**
 * 自定义异常类，用于抛出带有特定错误码和信息的异常。
 * 继承自RuntimeException，可以在运行时抛出该异常。
 */
public class CustomException extends RuntimeException {

    /** 错误码，表示具体的错误类型 */
    private String code;

    /** 错误信息，描述具体的错误详情 */
    private String msg;

    /**
     * 使用ResultCodeEnum枚举来初始化自定义异常
     * @param resultCodeEnum 枚举类型，包含错误码和错误信息
     */
    public CustomException(ResultCodeEnum resultCodeEnum) {
        // 从枚举中获取错误码和错误信息
        this.code = resultCodeEnum.code;
        this.msg = resultCodeEnum.msg;
    }

    /**
     * 使用自定义的错误码和错误信息来初始化自定义异常
     * @param code 错误码
     * @param msg 错误信息
     */
    public CustomException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 获取错误码
     * @return 返回错误码
     */
    public String getCode() {
        return code;
    }

    /**
     * 获取错误信息
     * @return 返回错误信息
     */
    public String getMsg() {
        return msg;
    }
}
