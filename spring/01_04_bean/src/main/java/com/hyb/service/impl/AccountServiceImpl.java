package com.hyb.service.impl;

import com.hyb.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    public AccountServiceImpl() {
        System.out.println("对象被创建了");
    }

    public void  saveAccount(){
        System.out.println("AccountServiceImpl中的saveAccount执行了");
    }
    public void  init(){
        System.out.println("对象初始化了。。。");
    }

    public void  destroy(){
        System.out.println("对象销毁了。。。");
    }


}
