package com.hyb.controller;

import com.hyb.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

/**
 * 常用的注解
 *   @RequestParam
 *       作用：
 *          把请求中指定名称的参数给控制器中的形参赋值。
 *     属性：
 *          value：请求参数中的名称。
 *          required：请求参数中是否必须提供此参数。默认值：true。表示必须提供，如果不提供将报错。
 *   @RequestBody
 *       作用：
 *          用于获取请求体内容。直接使用得到是 key=value&key=value...结构的数据。
 *          get请求方式不适用。
 *      属性：
 *          required：是否必须有请求体。默认值是:true。当取值为 true 时,get 请求方式会报错。如果取值为 false，get请求得到是null。
 *   @PathVaribale
 *       作用：
 *          用于绑定 url 中的占位符。例如：请求 url 中 /delete/{id}，这个{id}就是 url 占位符。
 *          url 支持占位符是 spring3.0 之后加入的。是 springmvc 支持 rest 风格 URL 的一个重要标志。
 *      属性：
 *          value：用于指定 url 中占位符名称。
 *          required：是否必须提供占位符。
 *   @HiddentHttpMethodFilter
 *       作用：
 *           由于浏览器 form 表单只支持 GET 与 POST 请求，而 DELETE、PUT 等 method 并不支持，Spring3.0 添
 *           加了一个过滤器，可以将浏览器请求改为指定的请求方式，发送给我们的控制器方法，使得支持 GET、POST、PUT
 *           与 DELETE 请求。
 *   @RequestHeader
 *       作用：
 *          用于获取请求消息头。
 *       属性：
 *          value：提供消息头名称
 *          required：是否必须有此消息头
 *       注：
 *          在实际开发中一般不怎么用
 *   @CookieValue
 *       作用：
 *          用于把指定 cookie 名称的值传入控制器方法参数。
 *       属性：
 *          value：指定 cookie 的名称。
 *          required：是否必须有此 cookie。
 *   @ModelAttribute
 *       作用：
 *          该注解是 SpringMVC4.3 版本以后新加入的。它可以用于修饰方法和参数。
 *          出现在方法上，表示当前方法会在控制器的方法执行之前，先执行。它可以修饰没有返回值的方法，也可以修饰有具体返回值的方法。
 *          出现在参数上，获取指定的数据给参数赋值。
 *      属性：
 *          value：用于获取数据的 key。key 可以是 POJO 的属性名称，也可以是 map 结构的 key。
 *      应用场景：
 *          当表单提交数据不是完整的实体类数据时，保证没有提交数据的字段使用数据库对象原来的数据。
 *   @SessionAttribute
 *       作用：
 *           用于多次执行控制器方法间的参数共享。
 *      属性：
 *          value：用于指定存入的属性名称
 *          type：用于指定存入的数据类型。
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes(value = "msg")  //把msg=zhangsan存入session域中
public class AnnoController {

    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name") String username){
        System.out.println("执行了。。。。。。。。。。。。");
        System.out.println(username);
        return "success";
    }

    /**
     * 获取到请求体的内容
     * @param body
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println("执行了。。。。。。。。。。。。");
        System.out.println(body);//username=zhangsan&age=58
        return "success";
    }

    /**
     * PathVariable注解
     * @return
     */
    @RequestMapping("/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(name = "sid") String id){
        System.out.println("执行了。。。。。。。。。。。。");
        System.out.println(id);//9999
        return "success";
    }

    /**
     * 获取请求头的值
     * @param header
     * @return
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String header){
        System.out.println("执行了。。。。。。。。。。。。");
        System.out.println(header);
        //text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
        return "success";
    }

    /**
     * 获取cookie的值
     * @return
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue){
        System.out.println("执行了。。。。。。。。。。。。");
        System.out.println(cookieValue);//6EF010BDA94B8E6DB4BDBB80CCE1957C
        return "success";
    }

    /**
     * ModelAttribute注解
     * @return
     */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User user){
        System.out.println("testModelAttribute执行了。。。。。。。。。。。。");
        System.out.println(user);

        return "success";
    }

    /**
     * 该方法会先执行,没有返回值
     */
    @ModelAttribute
    public void showUser(String uname, Map<String, User> map) {
        System.out.println("showUser执行了");
        //通过用户名查询数据库（模拟）
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());

        map.put("abc",user);

    }

    /**
     * 该方法会先执行,有返回值
     */
//    @ModelAttribute
//    public User showUser(String uname) {
//        System.out.println("showUser执行了");
//        //通过用户名查询数据库（模拟）
//        User user = new User();
//        user.setUname(uname);
//        user.setAge(20);
//        user.setDate(new Date());
//        return user;
//    }

    /**
     * SessionAttributes注解
     * @return
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model){
        System.out.println("testSessionAttributes。。。。。。。。。。。。");
        //底层会存储到request域对象当中
        model.addAttribute("msg","zhangsan");

        return "success";
    }

    /**
     * 获取值
     * @param modelMap
     * @return
     */
    @RequestMapping("/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap){
        System.out.println("getSessionAttributes。。。。。。。。。。。。");
        String msg =(String) modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }

    /**
     * 清除
     * @param status
     * @return
     */
    @RequestMapping("/delSessionAttributes")
    public String delSessionAttributes(SessionStatus status){
        System.out.println("delSessionAttributes。。。。。。。。。。。。");
        status.setComplete();
        return "success";
    }
}
