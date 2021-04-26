package com.hyb.test;

import com.hyb.dao.IAccountDao;
import com.hyb.domain.Account;
import com.hyb.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 使用junit单元测试,测试我们的配置
 */
public class AccountServiceTest {

    @Test
    public void TestFindAll(){
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        //3.执行方法
        List<Account> allAccount = as.findAllAccount();
        for (Account account : allAccount) {
            System.out.println(account);
        }
    }

    @Test
    public void TestFindOne(){
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        //3.执行方法
        Account accountById = as.findAccountById(1);
        System.out.println(accountById);
    }

    @Test
    public void TestSave(){
        Account account = new Account();
        account.setName("qpt");
        account.setMoney(123456F);
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        //3.执行方法
        as.saveAccount(account);
    }
    @Test
    public void TestUpdate(){
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        //3.执行方法
        Account account = as.findAccountById(4);
        account.setMoney(789456F);

        as.updateAccount(account);
    }
    @Test
    public void TestDelete(){
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        //3.执行方法
        as.deleteAccount(4);
    }
}
