package com.hyb.test;

import com.hyb.domain.Account;
import com.hyb.service.IAccountService;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用junit单元测试,测试我们的配置
 * spring整合junit的配置
 *      1.导入spring整合的Junit的jar（坐标）
 *      2.使用Junit提供的一个注解把原有的main方法替换，替换成spring提供的
 *           @RunWith
 *      3.告诉spring的运行器，spring和ioc的创建是基于xml还是注解的，并且说明位置
 *           @ContextConfiguration
 *                  locations:指定xml文件的位置，加上classpath关键字，表示在类路径下
 *                  classes:指定注解类所在位置
 *  当我们使用spring5.x时，要求junit的jar必须是4.1.2及以上
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    private IAccountService as;

    @Test
    public void TestFindAll(){

        //3.执行方法
        List<Account> allAccount = as.findAllAccount();
        for (Account account : allAccount) {
            System.out.println(account);
        }
    }

    @Test
    public void TestFindOne(){

        //3.执行方法
        Account accountById = as.findAccountById(1);
        System.out.println(accountById);
    }

    @Test
    public void TestSave(){
        Account account = new Account();
        account.setName("qpt");
        account.setMoney(123456F);

        //3.执行方法
        as.saveAccount(account);
    }
    @Test
    public void TestUpdate(){

        //3.执行方法
        Account account = as.findAccountById(4);
        account.setMoney(789456F);

        as.updateAccount(account);
    }
    @Test
    public void TestDelete(){

        //3.执行方法
        as.deleteAccount(4);
    }
}
