<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2021/4/22
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%--请求参数绑定--%>
<%--
    <a href="param/testParam?username=hehe&password=123">请求参数绑定</a>
--%>

    <%--封装到Account中,以及User中--%>
<%--    <form action="param/saveAccount" method="post">--%>
<%--        姓名：<input type="text" name="username"/> <br>--%>
<%--        密码：<input type="text" name="password"/> <br>--%>
<%--        金额：<input type="text" name="money"/> <br>--%>
<%--        用户姓名：<input type="text" name="user.uname"/> <br>--%>
<%--        用户年龄：<input type="text" name="user.age"/> <br>--%>
<%--        <input type="submit" value="提交"/>--%>
<%--    </form>--%>

    <%--封装到Account中,类中存list和map的集合--%>
<%--    <form action="param/saveAccount" method="post">--%>
<%--        姓名：<input type="text" name="username"/> <br>--%>
<%--        密码：<input type="text" name="password"/> <br>--%>
<%--        金额：<input type="text" name="money"/> <br>--%>

<%--        &lt;%&ndash;封装成User存到list中&ndash;%&gt;--%>
<%--        用户姓名：<input type="text" name="list[0].uname"/> <br>--%>
<%--        用户年龄：<input type="text" name="list[0].age"/> <br>--%>
<%--        &lt;%&ndash;封装成User存到Map中&ndash;%&gt;--%>
<%--        用户姓名：<input type="text" name="map['one'].uname"/> <br>--%>
<%--        用户年龄：<input type="text" name="map['one'].age"/> <br>--%>
<%--        <input type="submit" value="提交"/>--%>
<%--    </form>--%>


    <%--自定义类型装换器--%>
<%--    <form action="param/saveUser" method="post">--%>
<%--        &lt;%&ndash;&ndash;%&gt;--%>
<%--        用户姓名：<input type="text" name="uname"/> <br>--%>
<%--        用户年龄：<input type="text" name="age"/> <br>--%>
<%--        用户生日：<input type="text" name="date"/> <br>--%>
<%--        <input type="submit" value="提交"/>--%>
<%--    </form>--%>

    <a href="param/testServlet">Servlet原生的API</a>




</body>
</html>
