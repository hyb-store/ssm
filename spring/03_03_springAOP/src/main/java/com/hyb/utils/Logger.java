package com.hyb.utils;

/**
 * 用户记录日志的工具类，它里面提供了公共的代码
 */
public class Logger {
    /**
     * 用户打印日志，计划让其在切入点方法执行之前执行（切入点方法就是业务层代码）
     */
    public void printLog() {
        System.out.println("Logger中的printLog方法开始记录日志了。。。。。。。");
    }
}
