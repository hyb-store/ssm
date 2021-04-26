<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2021/4/24
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="js/jquery.min.js"></script>

    <script>
        //页面加载，绑定单击事件
        $(function () {
            $("#btn").click(function () {
                //alert("hello btn");
                //发送Ajax请求
                $.ajax({
                    url:"user/testAjax" , // 请求路径
                    contentType:"application/json;charset=utf-8",
                    data:'{"username":"hehe","password":"123456789","age":56}',
                    dataType:"json",
                    type:"POST",
                    success:function (data) {
                        //data：服务器段响应的json数据，进行解析
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                    }
                })

            });
        });

    </script>
</head>
<body>

    <a href="user/testString">testString</a>

    <br>

    <a href="user/testVoid">testVoid</a>

    <br>

    <a href="user/testModelAndView">testModelAndView</a>

    <br>

    <a href="user/testForwardOrRedirect">testForwardOrRedirect</a>

    <br>

    <button id="btn" >发送ajax请求</button>

</body>
</html>
