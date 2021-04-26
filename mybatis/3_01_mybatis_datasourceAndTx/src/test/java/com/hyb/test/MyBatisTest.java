package com.hyb.test;

import com.hyb.dao.IUserDao;
import com.hyb.domain.QueryVo;
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

public class MyBatisTest {

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
        //5.执行查询所有方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试保存操作
     */
    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("zhangsan");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("西安市长安区");

        System.out.println("保存之前："+user);//保存之前：User{id=null, username='zhangsan', birthday=Sun Apr 11 14:05:21 CST 2021, sex='男', address='西安市长安区'}
        //5.执行保存方法
        userDao.saveUser(user);
        System.out.println("保存之后："+user);//保存之后：User{id=51, username='zhangsan', birthday=Sun Apr 11 14:05:21 CST 2021, sex='男', address='西安市长安区'}
    }

    /**
     * 测试更新操作
     */
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(50);
        user.setUsername("张三");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("西安市长安区");

        //5.执行保存方法
        userDao.updateUser(user);
    }

    /**
     * 测试删除操作
     */
    @Test
    public void testDelete() {
        //5.执行删除方法
        userDao.deleteUser(48);
    }

    /**
     * 测试查询一个方法
     */
    @Test
    public void testFindOne() {
        //5.测试查询一个方法
        User user = userDao.findById(50);

        System.out.println(user);
    }

    /**
     * 测试模糊查询操作
     */
    @Test
    public void testFindByName() {
        //5.测试查询一个方法
        List<User> users = userDao.findByName("%王%");
//        List<User> users = userDao.findByName("王");

        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 查询总记录条数
     */
    @Test
    public void testFindTotal() {
        //5.测试查询一个方法
        int count = userDao.findTotal();

        System.out.println(count);
    }

    /**
     * 测试根据queryVo中的条件查询用户
     */
    @Test
    public void testFindByVo() {
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        vo.setUser(user);
        //5.测试查询一个方法
        List<User> users = userDao.findUserByVo(vo);
        for (User u : users) {
            System.out.println(u);
        }
    }
}
