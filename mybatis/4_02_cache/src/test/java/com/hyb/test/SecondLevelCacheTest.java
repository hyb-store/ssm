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

public class SecondLevelCacheTest {

    private InputStream in;
    private SqlSessionFactory factory;

    @Before //用于在测试方法执行之前执行
    public void init()  throws Exception{
        //1.读取配置文件,生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        factory = new SqlSessionFactoryBuilder().build(in);
    }

    @After //用于在测试方法执行之后执行
    public void destroy() throws Exception {
        in.close();
    }

    /**
     * 测试一级缓存
     */
    @Test
    public void testSecondLevelCache(){
        /**
         * 第一步：让mybatis框架支持二级缓存   SqlMapConfig.xml文件开启二级缓存
         * 第二步：当前映射文件支持二级缓存     配置相关的 Mapper 映射文件（IUserDao.xml）
         * 第三步：当前操作支持二级缓存     配置 statement 上面的 useCache 属性（在select标签上配置）
         */

        SqlSession sqlSession1 = factory.openSession();
        IUserDao dao1 = sqlSession1.getMapper(IUserDao.class);

        User user1 = dao1.findById(41);
        System.out.println(user1);//com.hyb.domain.User@68567e20
        sqlSession1.close();//一级缓存消失


        SqlSession sqlSession2 = factory.openSession();
        IUserDao dao2 = sqlSession2.getMapper(IUserDao.class);

        User user2 = dao2.findById(41);
        System.out.println(user2);//com.hyb.domain.User@11c9af63

        sqlSession2.close();

        System.out.println(user1 == user2);//false  二级缓存存放的是数据，不是对象。要用时创建新的对象，然后填充对象


    }


}
