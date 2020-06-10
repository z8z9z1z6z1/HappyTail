<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<span class="d-none" id="loginUserId">${sessionScope.LoginOK.id}</span>
<span class="d-none" id="loginUsername">${sessionScope.LoginOK.username}</span>
<nav class="navbar navbar-expand-lg navbar-light bg-white">
	<a class="navbar-brand" href="<c:url value='/HappyTailIndex.jsp'/>"
		style="display: block; margin: auto;"> <img
		src="<c:url value='/img/logo210_1905.png'/>" width="210" height="210"
		style="display: block; margin-left: 110px">
	</a>
	<ul class="nav navbar-nav navbar-right navbar-top top-bar">
	
	<c:if test="${ !empty LoginOK}">
		<li> 
			<span id="loginUserText" >Hello ,  ${sessionScope.LoginOK.username}</span>
		</li>
	</c:if>
	<c:if test="${!empty isForumArea}">
		<li onclick="openAddTopicDialog()">
			<i class="fas fa-edit fa-2x"></i>
		</li>
	</c:if>
		<li>
			<c:if test="${empty LoginOK}">
			<a href="<c:url value='/login' />" title="登入">
				<i class='fas fa-user fa-2x'></i>
			</a>
			</c:if>
			<c:if test="${ !empty LoginOK}">
			<a href="<c:url value='/logoutCheck' />" title="登出">
				<i class='fas fa-user fa-2x'></i>
			</a>
			</c:if>
		</li>

<!-- 		<li> -->
<!-- 			<i class='fas fa-bell fa-2x'></i> -->
<!-- 			<span class="counter">10</span>			 -->
<!-- 		</li> -->
		<li>
			<div class="dropdown notice-dropdown">
			  <i class='fas fa-bell fa-2x dropdown-toggle' data-toggle="dropdown" ></i>
			  <span class="d-none counter"></span>	
			  <div id="notice-list" class="dropdown-menu dropdown-menu-right">
<!-- 			  	<button type="button" class="dropdown-item" onclick="noticeLink(id,link)"> -->
<!-- 				    replyusername 回覆了你的文章 title -->
<!-- 				</button> -->
<!-- 			    <a class="dropdown-item" href="/happytail">replyusername 回覆了你的文章 title</a> -->
<!-- 			    <a class="dropdown-item" href="#">thumbsUpusername 對你的文章title 按了value 表示心情</a> -->
<!-- 			    <a class="dropdown-item" href="#">thumbsUpusername 對你的回覆按了讚</a> -->
<!-- 			    <a class="dropdown-item" href="#">追蹤的文章 title 更新了，快去看看吧！</a> -->
			  </div>
			</div>			
		</li>
		<li>
			<a class="right sidenav-trigger show-on-medium-and-up" data-target="side-nav" href="#"> 
				<i class="fa fa-align-justify fa-2x" onclick="openNav()"></i>
			</a>
		</li>
	</ul>
</nav>

<nav class="navbar navbar-expand-lg navbar-light bg-light">

	<div class="collapse navbar-collapse" id="navbarNavDropdown">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link"
				href="<c:url value='/HappyTailIndex.jsp'/> ">首頁 <span
					class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="#">關於我們</a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#"
				id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false"> 我們的服務 </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
					<a class="dropdown-item" href="<c:url value='/shopIndex'/>">網路商城</a> 
					<a class='dropdown-item' href="<c:url value='/Evaluationlist?id=${petMembers.id}' />">美容服務預約</a> 
					<a class="dropdown-item" href="<c:url value='/forum/topiclist?isForumArea=isForumArea' />">寵物論壇</a>
				</div></li>
			<li class="nav-item"><a class="nav-link" href="#">聯絡我們</a></li>
		</ul>
	</div>
<!-- 	<form class="form-inline"> -->
<!-- 		<input class="form-control mr-sm-2" type="search" placeholder="Search" -->
<!-- 			aria-label="Search"> -->
<!-- 		<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button> -->
<!-- 	</form> -->
</nav>

<div id="mySidenav" class="sidenav">
	<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
	<!-- <a href="#">About</a>
       <a href="#">Services</a>
       <a href="#">Clients</a>
       <a href="#">Contact</a> -->

	<span style="color: white; font-family: fantasy; font-size: 18px;"><img
		src="<c:url value='/img/logo_white3.png'/>">Happy Tail</span> <a
		href="#home">首頁</a> <a href="#notice">通知</a>
	<c:if test="${!empty LoginOK}">
		<a href="<c:url value='/memberCenter'/>">個人頁面</a>
	</c:if>
	<c:if test="${empty LoginOK}">
		<a href="<c:url value='/login'/>">個人頁面</a>
	</c:if>

	<a href="<c:url value='/shopIndex'/> ">網路商城</a> <a
		href="<c:url value='/Evaluationlist?id=${petMembers.id}' />">美容服務預約</a> <a
		href="<c:url value='/forum/topiclist?isForumArea=isForumArea' />">寵物論壇</a> 
		<a class="subheader">認識我們</a>

</div>

