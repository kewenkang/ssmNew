<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhangxu
  Date: 2018/1/5
  Time: 上午8:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Saleperson homepage</title>
</head>
<body align="center">
<h4 style="color: blue;">personal information</h4>
<table border="1" align="center">
    <tr>
        <th>id</th>
        <th>username</th>
        <th>password</th>
        <%--<th>permitted</th>--%>
    </tr>
    <tr>
        <td>${user.id}</td>
        <td>${user.username}</td>
        <td>${user.password}</td>
        <%--<td>${user.permitted}</td>--%>
    </tr>
</table>

<h4 style="color: blue;">sale information</h4>
<table border="1" align="center">
    <tr>
        <th>town</th>
        <th>locks</th>
        <th>stocks</th>
        <th>barrels</th>
        <th>year</th>
        <th>month</th>
    </tr>
    <c:forEach items="${sales}" var="sale">
        <tr>
            <td>${sale.town}</td>
            <td>${sale.locksNum}</td>
            <td>${sale.stocksNum}</td>
            <td>${sale.barrelsNum}</td>
            <td>${sale.year}</td>
            <td>${sale.month}</td>
        </tr>
    </c:forEach>
</table>
<h4 style="color: blue;">settle accounts</h4>
<form method="post" action="/middleware/commission/getSalaryMonthly">
    year: <input required type="number" min="0" name="year" value="2018"/><br/>
    month: <input required type="number" min="0" name="month" value="6"/><br/>
    <button type="submit" value="sumbit">submit</button><br/>
</form>

<%--<form method="post" action="/commission/addSalePerson">--%>
    <%--username: <input type="text" name="username"/><br/>--%>
    <%--password: <input type="password" name="password"/><br/>--%>
    <%--<input type="text" name="permitted" hidden="hidden" value="0"/>--%>
    <%--type:<input type="radio" name="type" value="1"/><label>saleperson</label><br/>--%>
    <%--<button type="submit" value="sumbit">submit</button>--%>
<%--</form>--%>
<h4 style="color: blue;">make a deal</h4>
<form method="post" action="/middleware/commission/makeADeal">
    <%--saleperson: <input type="text" name="salePersonId" value="4"/><br/>--%>
    town: <select name="town" required>
        <option value="NewYork">NewYork</option>
        <option value="Beijing">Beijing</option>
        <option value="Tokyo">Tokyo</option>
        <option value="Toronto">Toronto</option>
        <option value="California">California</option>
        <option value="Clombia">Clombia</option>
        <option value="London">London</option>
    </select><br/>
    locks: <input required type="number" min="0" name="locksNum"/><br/>
    stocks: <input required type="number" min="0" name="stocksNum"/><br/>
    barrels: <input required type="number" min="0" name="barrelsNum"/><br/>
    year: <input required type="number" min="0" name="year" value="2018"/><br/>
    month: <input required type="number" min="0" name="month" value="6"/><br/>
    <button type="submit" value="sumbit">submit</button><br/>
    ${result}
</form>
</body>
</html>