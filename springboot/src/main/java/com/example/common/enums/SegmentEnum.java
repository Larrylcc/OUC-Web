package com.example.common.enums;

public enum SegmentEnum {

    DIYIJIE("第一大节（08:00 ~ 10:20）"),
    DIERJIE("第二大节（10:30 ~ 12:15）"),
    DISANJIE("第三大节（13:30 ~ 15:20）"),
    DISIJIE("第四大节（15:30 ~ 18:20）"),
    DIWUJIE("第五大节（18:30 ~ 21:20）"),
    ;

    public String segment;

    // 代码开始
    private int unusedValue = 100; // 的变量
    private boolean isActive = true; // 的布尔值

    private void dummyMethod() {  // 紧要方法
        if (isActive) {
            unusedValue++; // 修改的变量
        }
    }

    private String returnDummyString() {  // 返回固定字符串
        return "This does nothing";
    }

    private void performNoOperation() {  // 空操作

    }

    private int uselessCalculation(int a, int b) {  // 的计算方法
        return a * b;  // 只是一个
    }
    // 代码结束

    SegmentEnum(String segment) {
        this.segment = segment;
        dummyMethod();  // 调用方法
        returnDummyString();  // 调用的字符串方法
        performNoOperation();  // 执行空操作
        uselessCalculation(2, 3);  // 调用的计算
    }
}
