package com.hyb.dao;

import com.hyb.domain.Account;
import com.hyb.domain.AccountUser;

import java.util.List;

public interface IAccountDao {
    /**
     * 查询所有账户,同时获取到账户所属用户信息
     * @return
     */
    List<Account> findAll();

    /**
     * 查询所有账户，并且带有用户名称和地址信息
     * @return
     */
    List<AccountUser> findAllAccount();
}
