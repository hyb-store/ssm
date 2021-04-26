package com.hyb.dao;

import com.hyb.domain.Account;

import java.util.List;

/**
 * 账户的持久层接口
 */
public interface IAccountDao {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 查询一个
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存
     */
    void saveAccount(Account account);

    /**
     * 更新
     */
    void updateAccount(Account account);

    /**
     * 删除
     */
    void deleteAccount(Integer accountId);

    /**
     * 根据名称查询账户，如果结果有唯一一个就返回，没有就返回null，结果集有多个就抛异常
     * @param accountName
     * @return
     */
    Account findAccountByName(String accountName);
}
