package com.hyb.dao.impl;


import com.hyb.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * 账户的持久层实现类
 *
 * 作用：用于把当前类对象存入spring容器中.和在XML配置文件中编写一个<bean>标签实现的功能是一样的
 *  *          属性：
 *  *              value：用于指定bean的id。当我们不写时，它的默认值是当前类名，且首字母改小写。
 */
@Repository("accountDao2")
public class AccountDaoImpl2 implements IAccountDao {

    public  void saveAccount(){

        System.out.println("保存了账户2222222222222");
    }
}
