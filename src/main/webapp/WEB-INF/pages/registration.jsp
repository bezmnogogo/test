<%--
  Created by IntelliJ IDEA.
  User: home
  Date: 25.06.16
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
    <title>Title</title>
    <link href=""
</head>
<body>
<header class="clearfix" id="header">
    <div class="logo" href=" "></div>
    <nav class="clearfix" id="hdmenu">
        <ul class= "menu">
            <li><a href=" ">Ставки</a></li>
            <li><a href=" ">Результаты</a></li>
            <li><a href=" ">Регистрация</a></li>
            <li><a href=" ">Вход</a></li>
        </ul>
    </nav>
</header>
<h1>РЕГИСТРАЦИЯ</h1>
<p>Вам нужно зарегистрироваться, чтобы начать делать ставки ${message}</p>
<form class="m-t" role="form" method="post" action="<c:url value="/registration" /> ">
    <div align = "center"class = "formRegistration">
        <div class="buttonName"><input type="text" placeholder="Имя" name = "username" required /></div>
        <div class="buttonEmail"><input type="email" placeholder="Email" name = "mail" required /></div>
        <div class="buttonPassword"><input type="password" placeholder="Пароль" name = "password" required /></div>
        <div class="buttonPay"><input type="text" placeholder="Web - кошелек" name = "webPurse" required /></div>
        <button type="submit" class="btn btn-primary block full-width m-b">Registrate</button>
    </div>
</form>
<footer class = "clearfix" id = "footer">

    <div class="contacts">
        <div class="navigation">
            <nav class="navigation">
                <ul class = "menu">
                    <li><a href=" ">Результаты</a></li>
                    <li><a href=" ">Мои ставки</a></li>
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
