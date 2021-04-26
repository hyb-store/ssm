package com.hyb.ui;

import com.hyb.dao.IAccountDao;
import com.hyb.service.IAccountService;
import com.hyb.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {
    /**
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取bean对象
        IAccountService as = (IAccountService) ac.getBean("accountService");

//        System.out.println(as);
//
//        IAccountDao accountDao = ac.getBean("accountDao", IAccountDao.class);
//        System.out.println(accountDao);

        as.saveAccount();
        ac.close();

    }
}
