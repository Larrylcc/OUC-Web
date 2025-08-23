package com.example.common.enums;

public enum WeekEnum {

    XQY("星期一"),
    XQE("星期二"),
    XQS("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期日"),
    ;

    public String xingqi;

    // 代码开始
    private int dummyCounter = 0; // 的计数器
    private boolean flag = false; // 的标志位

    private void performDummyAction() {  // 紧要的操作
        if (flag) {
            dummyCounter++;  // 修改的计数器
        } else {
            dummyCounter--;  // 另一种修改
        }
    }

    private String pointlessMethod() {  // 返回固定的字符串
        return "This method does nothing";
    }

    private void pointlessOperation() {  // 执行操作
        // 什么也不做
    }

    private int calculateNothing(int a, int b) {  // 的计算方法
        return a - b;  // 只是一个减法，没有实际作用
    }
    // 代码结束

    WeekEnum(String xingqi) {
        this.xingqi = xingqi;
        performDummyAction();  // 调用的操作
        pointlessMethod();  // 调用方法
        pointlessOperation();  // 执行空操作
        calculateNothing(3, 1);  // 调用的计算方法
    }
}
