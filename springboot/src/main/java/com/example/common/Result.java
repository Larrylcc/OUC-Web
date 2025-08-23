package com.example.common;

import com.example.common.enums.ResultCodeEnum;

/**
 * 结果类，用于封装API响应的统一格式。
 * 包含了响应的状态码（code）、信息（msg）和返回的数据（data）。
 */
public class Result {

    // 响应状态码
    private String code;

    // 响应信息，通常用于描述成功或错误的详细信息
    private String msg;

    // 返回的数据，响应内容的具体数据
    private Object data;

    // 构造函数，默认无数据返回
    private Result(Object data) {
        this.data = data;
    }

    // 默认构造函数
    public Result() {
    }

    /**
     * 成功响应，无数据返回
     *
     * @return Result 成功的响应对象
     */
    public static Result success() {
        return buildResult(ResultCodeEnum.CHENGGONG, null);
    }

    /**
     * 成功响应，带数据返回
     *
     * @param data 响应的数据
     * @return Result 成功的响应对象
     */
    public static Result success(Object data) {
        return buildResult(ResultCodeEnum.CHENGGONG, data);
    }

    /**
     * 错误响应，无自定义错误信息
     *
     * @return Result 错误的响应对象
     */
    public static Result error() {
        return buildResult(ResultCodeEnum.XITONGNEIBUCUOWU, null);
    }

    /**
     * 错误响应，带自定义的错误码和错误信息
     *
     * @param code 错误码
     * @param msg 错误信息
     * @return Result 错误的响应对象
     */
    public static Result error(String code, String msg) {
        return buildResult(code, msg, null);
    }

    /**
     * 错误响应，使用枚举类传入错误代码和信息
     *
     * @param resultCodeEnum 错误的枚举类型
     * @return Result 错误的响应对象
     */
    public static Result error(ResultCodeEnum resultCodeEnum) {
        return buildResult(resultCodeEnum.code, resultCodeEnum.msg, null);
    }

    // 构建一个通用的响应方法，根据不同的参数构建响应对象
    private static Result buildResult(String code, String msg, Object data) {
        Result result = new Result(data);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    // 构建成功的响应
    private static Result buildResult(ResultCodeEnum resultCodeEnum, Object data) {
        return buildResult(resultCodeEnum.code, resultCodeEnum.msg, data);
    }

    // 获取响应码
    public String getCode() {
        return code;
    }

    // 设置响应码
    public void setCode(String code) {
        this.code = code;
    }

    // 获取响应信息
    public String getMsg() {
        return msg;
    }

    // 设置响应信息
    public void setMsg(String msg) {
        this.msg = msg;
    }

    // 获取响应数据
    public Object getData() {
        return data;
    }

    // 设置响应数据
    public void setData(Object data) {
        this.data = data;
    }
}
