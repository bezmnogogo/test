<%--
  Created by IntelliJ IDEA.
  User: home
  Date: 27.06.16
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/result.css"/>"/>
</head>
<body>
<header class="clearfix" id="header">
    <nav class="clearfix" id="hdmenu">
        <ul class= "menu">
            <li> <a href="<c:url value="/bet/bet"/>">Ставки</a>
            <li> <a href="<c:url value="/privateRoom/"/>">Личный кабинет</a>
            <li><a href="<c:url value="/logout"/>">Выход</a></li>
        </ul>
    </nav>
</header>
<div class="result"><h1>РЕЗУЛЬТАТЫ</h1></div>
<table class="tablerate" id="table rate">
    <caption>Мои ставки</caption>
    <tr>
        <th>МАТЧ</th>
        <th>СЧЕТ</th>
        <th>КОЭФФИЦИЕНТ</th>
        <th>СУММА</th>
        <th>ВЫИГРЫШ</th>
    </tr>
    <c:forEach var="bet" items="${betList}">
    <tr id="${bet.id}">
        <td>${bet.match.toString()}</td>
        <td>${bet.match.homeGoals} - ${bet.match.guestGoals}</td>
        <td>${bet.winCoefficient}</td>
        <td>${bet.amount}</td>
        <td>${bet.winAmount}</td>
    </tr>
    </c:forEach>
</table>
<table class="tablepurse" id="table purse">
    <tr>
        <td>Номер web - кошелька</td><td>0000 0000 0000</td>
    </tr>
    <tr>
        <td>Номер карточки</td><td>0000 0000 0000</td>
    </tr>
</table>
<footer class = "clearfix" id = "footer">

    <div class="contacts">
        <div class="navigation">
            <nav class="navigation">
                <ul class = "menu">
                    <li><a href="<c:url value="/bet/results"/>">Результаты</a></li>
                    <li><a href="<c:url value="/bet/bet"/>">Мои ставки</a></li>
                    <li><a href=" ">Инструкция</a></li>
                </ul>
            </nav>
        </div>
        <div class = "telephone">
            <img src="Image/Icons/iconphone.png"><br>
            <b>Телефон</b>
            <p>+375(29)000-000-000</p>
        </div>
        <div class="adress">
            <img src="Image/Icons/iconadress.png" ><br>
            <b>Адрес</b>
            <p>Гикало 9, Минск</p>
        </div>
        <div class = "email">
            <img src="Image/Icons/iconmap.png" ><br>
            <b>Email</b>
            <p>stavki@gmail.com</p>
        </div>
    </div>
    <div class="avtorfoot">
        <p>©2016 Stavki.by</p>
    </div>
</footer>

</body>
</html>
