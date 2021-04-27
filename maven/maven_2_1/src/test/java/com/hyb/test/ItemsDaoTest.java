package com.hyb.test;

import com.hyb.dao.ItemsDao;
import com.hyb.domain.Items;
import com.hyb.service.ItemsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ItemsDaoTest {

    @Test
    public void findById() {

        //获取spring容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

//        //dao测试
//        //从容器中拿到所需的代理对象
//        ItemsDao itemsDao = ac.getBean(ItemsDao.class);
//        //调用方法
//        Items items = itemsDao.findById(2);
//        System.out.println(items.getName());

        //service测试
        ItemsService is = ac.getBean(ItemsService.class);
        Items items = is.findById(1);
        System.out.println(items.getName());

    }
}
