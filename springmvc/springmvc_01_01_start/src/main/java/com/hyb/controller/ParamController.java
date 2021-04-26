package com.hyb.controller;

import com.hyb.domain.Account;
import com.hyb.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 请求参数绑定
 */
@Controller
@RequestMapping("/param")
public class ParamController {
    /**
     * 请求参数绑定入门
     * @return
     */
    @RequestMapping("/testParam")
    public String testParam(String username,String password) {//http://localhost:8080/param/testParam?username=hehe&password=123

        System.out.println("执行了。。。");
        System.out.println("用户名："+username);//用户名：hehe
        System.out.println("密码："+password);//密码：123
        return "success";

    }

    /**
     * 把数据封装到javaBean的类当中
     * @param account
     * @return
     */
    @RequestMapping(path = "/saveAccount")
    public String saveAccount(Account account) {

        System.out.println("执行了。。。");
        System.out.println(account);
        //Account{username='zhangsan', password='12345678', money=10000.0}
        //Account{username='zhangsan', password='12345678', money=10000.0, user=User{uname='lisi', age=987654321}}
        //Account{username='张三', password='12345678', money=10000.0, list=[User{uname='李四', age=12}], map={one=User{uname='造三', age=23}}}

        return "success";

    }

    /**
     * 自定义类型装换器
     * @param user
     * @return
     */
    @RequestMapping(path = "/saveUser")
    public String saveUser(User user) {

        System.out.println("执行了。。。");
        System.out.println(user);

        return "success";
    }

    /**
     * 原生的API
     * @return
     */
    @RequestMapping(path = "/testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("执行了。。。");
        System.out.println(request);//org.apache.catalina.connector.RequestFacade@178abf86
        System.out.println(response);//org.apache.catalina.connector.ResponseFacade@1dffe14a

        HttpSession session = request.getSession();
        System.out.println(session);//org.apache.catalina.session.StandardSessionFacade@6bea8aee

        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);//org.apache.catalina.core.ApplicationContextFacade@3ad213a4


        return "success";
    }
}
