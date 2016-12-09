<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
	 <head>
		 <meta charset="utf-8">
		 <title>home page</title>
		 <style>
			 body{background: darkgray;
			 background-image: url('/resources/css/image/mainback.png');}
		 </style>
		 <link rel="stylesheet" href="<c:url value="/resources/css/FirstPageStyle2.css"/>"/>
	</head>
	<body>
		<header class="clearfix" id="header">
			<a class="logo" href=" "></a>
			<nav class="clearfix" id="hdmenu">
				<ul class="menu">
					<c:if test="${not empty login}">
						<li><a href="<c:url value="/privateRoom/"/>">Личный кабинет</a> </li>
					</c:if>
							<li><a href="<c:url value="/registration"/>">Регистрация</a></li>
						   <li><a href="<c:url value="/login"/>">${status}<span style="color:blue">${login}</span></a></li>
				</ul>	
			</nav>
			<h1>СТАВКИ НА СПОРТ</h1>
			<div class="sidebar clearfix" id="sidebar">
				<p class="quicktext" id="firstqt">Кризис <br>не беспокоит</p>
				<p class="quicktext" id="secondqt">Работать на дядю больше не надо</p>
				<p class="quicktext" id="thirdqt">Появяться деньги, чтобы реализовать свои мечты</p>
			</div>
		</header>
		<footer class="clearfix" id="footer">
			<nav>
				<ul class="menu">
					<li><a href="<c:url value="/bet/results"/>">Результаты</a></li>
					<li><a href="<c:url value="/bet/bet"/>">Мои ставки</a></li>
					<li><a href="<c:url value="/bet/allBets"/>">Инструкция</a></li>
				</ul>	
			</nav>
			<div class="contacts clearfix">
				<div class="telephone">
				    <img src="image/iconphone.png" height="80px"; width="70px"><br>
					<p>Телефон</p>
					<a><i>+375(29)000-000-000</i></a>
				</div>
				<div class="address">
					<img src="image/iconadress.png" height="80px"; width="70px"><br>
					<p>Адрес</p>
					<p>Гикало 9 Минск</p>
				</div>
				<div class="email">
					<img src="image/iconmap.png" height="80px"; width="70px"><br>
					<p>Email</p>
					<a href=" ">stavki@gmail.com</a>
				</div>
			</div>
			<div class="avtorfoot"><p>@2016 Stavki.by</p></div>
		</footer>
	</body>
</html>