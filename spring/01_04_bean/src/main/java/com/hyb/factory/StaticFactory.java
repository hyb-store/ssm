package com.hyb.factory;

import com.hyb.service.IAccountService;
import com.hyb.service.impl.AccountServiceImpl;

/**
 * 模拟一个工厂类。（该类可能存在于jar包中，我们无法通过修改源码的方式提供默认构造函数）
 */
public class StaticFactory {

    public static IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
