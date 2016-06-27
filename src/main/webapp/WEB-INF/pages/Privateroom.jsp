<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
    <head>
		<meta charset="utf-8">
			<link href='https://fonts.googleapis.com/css?family=Roboto+Condensed:300&subset=latin,cyrillic' rel='stylesheet' type='text/css'>
			<link href='https://fonts.googleapis.com/css?family=Rubik+One&subset=latin,cyrillic' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" href="<c:url value="/resources/css/privateroom.css"/>"/>
	</head>
    <body>
		<header class="clearfix" id="header">
			<nav class="clearfix" id="hdmenu">
				<ul class= "menu">
					<li> <a href="<c:url value="/bet/bet"/>">Ставки</a>
					<li> <a href="<c:url value="/privateRoom/"/>">Личный кабинет</a>
				</ul>
			</nav>				
		</header>
		<h1>Это Ваш личный кабинет, ${login}</h1>
			<table class="tablerate" id="table rate">
				 <caption>Мои ставки</caption>
				 <tr>
					 <th>МАТЧИ</th>
					 <th>СТАТУС</th>
					 <th>КОЭФФИЦИЕНТ</th>
					 <th>СУММА</th>
					 <th>ВЫИГРЫШ</th>
				</tr>
				<c:forEach var="bet" items="${betList}">
				<tr id="row_${bet.match.id}">
					 <td>${bet.match.toString()}</td>
					<td>${bet.match.status}</td>
					 <td>${bet.winCoefficient}</td>
					 <td>${bet.amount}</td>
					 <td>${bet.winAmount}</td>
				</tr>
				</c:forEach>
			</table>
			<table class="tablepurse" id="table purse">
				 <tr>
					<td>кол-во оставшихся средств</td><td>${amount}</td>
				 </tr>
				 <tr>
					<td>Номер карточки</td><td>${purse}</td>
				 </tr>
			</table>
		<footer class = "clearfix" id = "footer">
			
			 <div class="contacts">
				<div class="navigation">
					<nav class="navigation">
						<ul class = "menu">
						   <li><a href="<c:url value="/bet/results"/>">Результаты</a></li>
						   <li><a href="<c:url value="/bet/bet"/>">Мои ставки</a></li>
						   <li><a href="<c:url value="/"/>">Инструкция</a></li>
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
	