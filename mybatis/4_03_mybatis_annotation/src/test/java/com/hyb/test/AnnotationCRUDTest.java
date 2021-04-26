package com.hyb.test;

import com.hyb.dao.IUserDao;
import com.hyb.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class AnnotationCRUDTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;

    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws Exception {
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("annotation");
        user.setAddress("北京");
        user.setSex("男");
        user.setBirthday(new Date());

        userDao.saveUser(user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setUsername("update");
        user.setAddress("北京");
        user.setSex("男");
        user.setId(52);
        user.setBirthday(new Date());

        userDao.updateUser(user);
    }

    @Test
    public void testDelete() {
      userDao.deleteUser(52);
    }

    @Test
    public void testFindOne() {
        User user = userDao.findById(50);
        System.out.println(user);
    }

    @Test
    public void testFindUserByName() {
        List<User> users = userDao.findUserByName("%王%");
//        List<User> users = userDao.findUserByName("王");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testTotal() {
        int total = userDao.findTotalUser();
        System.out.println(total);
    }

}
