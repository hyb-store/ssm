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
import java.util.List;

public class UserTest {

    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;
    private SqlSessionFactory factory;

    @Before //用于在测试方法执行之前执行
    public void init()  throws Exception{
        //1.读取配置文件,生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession();
       // sqlSession = factory.openSession(true);自动提交，可以不用sqlSession.commit()方法
        //4.获取dao的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After //用于在测试方法执行之后执行
    public void destroy() throws Exception {
        //提交事务
        sqlSession.commit();//Committing JDBC Connection

        //6.释放资源
        sqlSession.close();
        in.close();
    }

    /**
     * 测试一级缓存
     */
    @Test
    public void testFirstLevelCache(){
       User user1 = userDao.findById(41);
        System.out.println(user1);//com.hyb.domain.User@117e949d

        User user2 = userDao.findById(41);
        System.out.println(user2);//com.hyb.domain.User@117e949d

        System.out.println(user1 == user2);//true

        System.out.println("--------------------------");

        User user3 = userDao.findById(42);
        System.out.println(user1);//com.hyb.domain.User@117e949d

//       sqlSession.close();
//       sqlSession = factory.openSession();
//       userDao = sqlSession.getMapper(IUserDao.class);
        sqlSession.clearCache();//清除缓存

        User user4 = this.userDao.findById(42);
        System.out.println(user3);//com.hyb.domain.User@7b02881e

        System.out.println(user3 == user4);//false
    }

    /**
     * 测试缓存同步
     */
    @Test
    public void testClearCache(){
        /**
         * 一级缓存是 SqlSession 范围的缓存，当调用 SqlSession 的修改，添加，删除，commit()，close()等方法时，就会清空一级缓存。
         */
        //1.根据id查询用户
        User user1 = userDao.findById(41);
        System.out.println(user1);//com.hyb.domain.User@117e949d
        //2.更新用户信息
        user1.setUsername("clearCache");
        user1.setAddress("天堂");

        userDao.updateUser(user1);

        //再度查询id为41的用户
        User user2 = userDao.findById(41);
        System.out.println(user2);//com.hyb.domain.User@7b02881e

        System.out.println(user1 == user2);//false


    }

}
