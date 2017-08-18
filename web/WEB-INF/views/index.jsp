<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2017/8/17
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>springmvc</title>
      <script src="./js/jquery-3.2.1.js"></script>
      <script type="text/javascript">
        $("#login").click(function () {
            var name = $("#name").val();
            var password = $("#password").val();

            if(name == null || name =="" || password == null || password == ""){
                alert("name or password can't be null");
                return;
            }

            $.ajax({
                url : "/index",
                type : "post",
                data : {"name":name,"password":password},
                success : function () {
                    alert("login successfully");
                }
            });

        });
      </script>
  </head>
  <body>
  <p>msg:${msg}<br/></p>
  <p>current time:${time}<br/></p>

  <input id="name" type="text" ><<br/>
  <input id="password" type="password"><br/>
  <input id="login" type="button" style="background: skyblue">

  </body>
</html>
