package com.hyb.service.impl;


import com.hyb.dao.IAccountDao;
import com.hyb.dao.impl.AccountDaoImpl;
import com.hyb.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao = new AccountDaoImpl();

    public void  saveAccount(){
        accountDao.saveAccount();
    }
}
