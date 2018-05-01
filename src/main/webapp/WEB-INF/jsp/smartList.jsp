<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhangxu
  Date: 2018/1/5
  Time: 上午8:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Smart列表</title>
</head>
<body>
<table border="1">
    <tr>
        <th>id</th>
        <th>type</th>
        <th>command</th>
        <th>operate_time</th>
        <th>operator</th>

    </tr>
<c:forEach items="${smartList}" var="smart">

        <tr>
            <td>${smart.id}</td>
            <td>${smart.type}</td>
            <td>${smart.command}</td>
            <td>${smart.operateTime}</td>
            <td>${smart.operator}</td>
        </tr>


</c:forEach>
</table>
</body>
</html>
