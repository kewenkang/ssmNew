<%--
  Created by IntelliJ IDEA.
  User: kewenkang
  Date: 2018/6/4
  Time: 上午11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login page</title>
    <style type="text/css">

    </style>
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
    <script type="text/javascript">
        function register() {
            var username = $("#username").val()
            var password = $("#password").val()
            if (username != "" && password != "") {
                $.ajax({
                    url: "/middleware/commission/register",
                    type: "POST",
                    data: {
                        username: username,
                        password: password
                    },
                    success: function (result) {
                        console.log(result)
                        var data = JSON.parse(result)
                        alert(data.result)
                    },
                    error: function (result) {
                        alert(result)
                        // console.log(result)
                    }
                })
            }else{
                alert("Invalid username or password!!!")
            }
        }
    </script>
</head>
<body align="center">


<form method="post" action="/middleware/commission/index">
    username: <input required type="text" id="username" name="username"/><br/>
    password: <input required type="password" id="password" name="password"/><br/>
    <%--<input type="text" name="permitted" hidden="hidden" value="0"/>--%>
    <%--type:<input type="radio" name="type" value="1"/><label>saleperson</label><br/>--%>
    <button type="submit" value="login">login</button><button type="button" onclick="register()" value="register">register</button>

</form>
</body>
</html>
