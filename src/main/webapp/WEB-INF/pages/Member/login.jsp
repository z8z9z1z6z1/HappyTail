<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
	xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
	layout:decorator="layout/offline">
<head>
<title>Login</title>

<link
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css"
	rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet" />

</head>
<body>
	<main layout:fragment="content">
		<article class="container" style="padding-top: 3%;">
			<header class="row">
				<blockquote class="flow-text left">
					<a href="<c:url value='/index.jsp' />" style="color: black">回首頁</a>
				</blockquote>
			</header>
			<header class="row">
				<div class="col s12">
					<h3 class="center">登入</h3>
					<h5 class="center">Sign in</h5>
					<%--                     <p class="center flow-text" th:if="${param.error}">請輸入正確的帳號或密碼!</p> --%>
				</div>
			</header>
			<section>
				<form action="<c:url value='loginCheck'/>" method="POST">
					<div class="row">
						<div class="col s12">
							<label> 帳號: <input type="text" name="email" 
								maxlength="30" data-length="30" required="required" />${errors.email}
							</label>
						</div>
					</div>
					<div class="row">
						<div class="col s12">
							<label> 密碼: <input type="password" name="password" 
								maxlength="15" data-length="15" required="required" />${errors.password}
							</label>
						</div>
					</div>
					<div class="row">
						<div class="col s12 center">
							<button class="btn" type="submit" name="login">登入</button>
							
							<button class="btn" type="button" name="Register">
								<a href="<c:url value='register' />" style="color: white">註冊</a>
							</button>
							<br>${errors.msg}
						</div>
					</div>
					<%--                     <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>
				</form>
			</section>
		</article>
	</main>
	



	
	
	<!-- <script src="/webjars/jquery/3.2.1/jquery.min.js"></script>
    <script src="/webjars/materializecss/0.100.2/js/materialize.min.js"></script> -->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
</body>
</html>