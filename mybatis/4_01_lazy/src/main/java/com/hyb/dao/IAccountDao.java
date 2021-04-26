package com.hyb.dao;

import com.hyb.domain.Account;

import java.util.List;

public interface IAccountDao {
    /**
     * 查询所有账户,同时获取到账户所属用户信息
     * @return
     */
    List<Account> findAll();

    /**
     * 根据用户账户信息查询账户信息
     * @param uid
     * @return
     */
    List<Account> findAccountById(Integer uid);

}
