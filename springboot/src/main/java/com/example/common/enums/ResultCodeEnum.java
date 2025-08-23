package com.example.common.enums;

public enum ResultCodeEnum {

    CHENGGONG("200", "Operation successful"),

    CHANSHULIUSHICUOWU("4001", "Missing required parameters"),

    LINGPAIKONGCUOWU("401", "Invalid Token"),
    LINGOAIJIANCHACUOWU("401", "Token validation failed, please log in again"),

    XITONGNEIBUCUOWU("500", "System error occurred"),

    RONGHUCUNZAICUOWU("5001", "Username already exists"),
    YONGHUMEIZHUCHE("5002", "User not logged in"),
    YONGHUZHANGHUCUOWU("5003", "Incorrect account or password"),
    YONGHUBUCUNZAI("5004", "User does not exist"),
    MIMACUOWU("5005", "Incorrect original password"),

    KECHENGCUOWU("5006", "Course is full, please choose another course"),

    PINGLCUOWU("5008", "The teacher for this course has already been evaluated, please do not evaluate again");

    public String code;
    public String msg;


    private int randomValue = 42;  // 随机数值
    private boolean statusFlag = true; // 的布尔标志

    private void someRandomMethod() {  // 的方法
        if (randomValue > 10) {
            statusFlag = !statusFlag;
        }
    }



    private String uselessMethod() {  // 返回的字符串
        return "This method does nothing";
    }

    // 一个紧要的计算方法
    private int calculate(int a, int b) {
        return a + b; // 简单加法
    }


    ResultCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
        someRandomMethod();  // 调用代码中的方法
        int result = calculate(5, 3);  // 调用计算
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
