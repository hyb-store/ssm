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

    @Before //用于在测试方法执行之前执行
    public void init()  throws Exception{
        //1.读取配置文件,生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
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

    @Test
    public void testFindAll(){
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println("------------每个用户信息----------");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }

    /**
     * 查询所有账户，并且带有用户名称和地址信息
     */
//    @Test
//    public void testFindAllAccount() {
//        List<AccountUser> aus = accountDao.findAllAccount();
//        for (AccountUser au : aus) {
//            System.out.println(au);
//        }
//    }

}
