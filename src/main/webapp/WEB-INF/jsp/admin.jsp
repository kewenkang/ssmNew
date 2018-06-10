<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kewenkang
  Date: 2018/6/5
  Time: 上午8:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gunsmith homepage</title>
    <script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
    <%--<script type="text/javascript" src="./js/jquery.js"></script>--%>
    <script type="text/javascript">
        function getsaleperson() {
            $.ajax({
                url: "/middleware/commission/getAllSalePerson",
                type: "GET",
                success: function (result) {
                    alert(result)
                }
            })
        }

    </script>
</head>
<body align="center">
<h4 style="color: blue;">Personal information</h4>
<table border="1"  align="center">
    <tr>
        <th>id</th>
        <th>username</th>
        <th>password</th>
    </tr>
    <tr>
        <td>${user.id}</td>
        <td>${user.username}</td>
        <td>${user.password}</td>
    </tr>
</table>


<%--<h4 style="color: green;">Saleperson list</h4>--%>
<%--<table border="1">--%>
    <%--<tr>--%>
        <%--<th>id</th>--%>
        <%--<th>username</th>--%>
        <%--<th>permitted</th>--%>
    <%--</tr>--%>
    <%--<c:forEach items="${salepersons}" var="saleperson">--%>
        <%--<tr>--%>
            <%--<td>${saleperson.id}</td>--%>
            <%--<td>${saleperson.username}</td>--%>
            <%--<td>${saleperson.permitted}</td>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>
<%--</table>--%>

<h4 style="color: blue;">Settle accounts</h4>
<form method="post" action="/middleware/commission/getUserSalaryMonthly">
    saleperson: <select name="id" required>
    <c:forEach items="${salepersons}" var="saleperson">
        <option value="${saleperson.id}">${saleperson.username}</option>
    </c:forEach>
    </select><br/>
    year: <input required type="number" min="0" name="year" value="2018"/><br/>
    month: <input required type="number" min="0" name="month" value="6"/><br/>
    <button type="submit" value="sumbit">submit</button><br/>
</form>

<h4 style="color: blue;">Sale information</h4>
<table border="1" align="center">
    <tr>
        <th>saleperson</th>
        <th>town</th>
        <th>locks</th>
        <th>stocks</th>
        <th>barrels</th>
        <th>year</th>
        <th>month</th>
    </tr>
    <c:forEach items="${sales}" var="sale">
        <tr>
            <td>${sale.saleperson.username}</td>
            <td>${sale.town}</td>
            <td>${sale.locksNum}</td>
            <td>${sale.stocksNum}</td>
            <td>${sale.barrelsNum}</td>
            <td>${sale.year}</td>
            <td>${sale.month}</td>
        </tr>
    </c:forEach>
</table>

<%--<button type="button" onclick="getsaleperson()">getsaleperson</button>--%>
<%--<h4 style="color: green;">sale list</h4>--%>
<%--<table border="1">--%>
    <%--<tr>--%>
        <%--<th>id</th>--%>
        <%--<th>username</th>--%>
        <%--<th>permitted</th>--%>

    <%--</tr>--%>
    <%--<c:forEach items="${salepersons}" var="saleperson">--%>
        <%--<tr>--%>
            <%--<td>${saleperson.id}</td>--%>
            <%--<td>${saleperson.username}</td>--%>
            <%--<td>${saleperson.permitted}</td>--%>
        <%--</tr>--%>

    <%--</c:forEach>--%>
<%--</table>--%>
</body>
</html>
