<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>top37</title>
</head>
<body>

	

	<header class="navbar-fixed-top">
		<nav>
			<ul>
				<li><a href="#about">About</a></li>
				<li><a href="#experience">Reservation</a></li>
				<li><a href="#projects">Introduction</a></li>
				<li><a href="#evaluation">Evaluation</a></li>
				<li><a href="#contact">contact</a></li>
				<li>|</li>
				<li><a href="<c:url value='query?memberId=${petMembers.memberId}' />">MyReservation</a></li>
				<li><a href="<c:url value='/HappyTailIndex.jsp' />">首頁</a></li>
			</ul>
		</nav>
	</header>
	
</body>
</html>