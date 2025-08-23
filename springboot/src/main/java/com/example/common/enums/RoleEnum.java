package com.example.common.enums;

public enum RoleEnum {

    GUANLIYUAN,

    LAOSHI,

    XUESHENG;

    // 代码开始
    private int placeholderValue = 99; // 的占位变量
    private String dummyString = "Dummy"; // 的字符串

    // 的计算方法
    private int addNumbers(int a, int b) {
        return a + b;
    }

    private void randomAction() {  // 紧要的操作
        if (placeholderValue > 50) {
            dummyString = "Updated";  // 更新的字符串
        }
    }

    private boolean uselessCheck() {  // 的布尔检查
        return placeholderValue == 99;
    }

    // 一个返回固定字符串的方法
    private String returnUselessValue() {
        return "This does nothing";
    }
    // 代码结束

    // 枚举构造函数
    RoleEnum() {
        randomAction();  // 调用代码中的方法
        addNumbers(2, 3);  // 调用的计算方法
    }
}
