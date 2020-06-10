<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>會員管理</title>


<%@include file="/WEB-INF/pages/include/coreLibrary.jsp"%>

</head>
<!-- class="hold-transition sidebar-mini" -->
<body>

	
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
	</ul>
</nav>
	
	<nav class="navbar navbar-expand-lg navbar-light bg-light">

	<div class="collapse navbar-collapse" id="navbarNavDropdown">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link"
				href="<c:url value='/admin-Index'/> ">回後台 <span
					class="sr-only">(current)</span>
			</a></li>
	</ul>
	</div>
	</nav>


	<div style='float: left; margin-right: 20px'>
		<a href="<c:url value='pageBackView?pageNum=1' />"><input
			class="btn btn-primary" type="button" value='查詢全部'></a><br>
		<br>
	</div>
	<div style="font-size: 20px">
		<form action="queryByPageBackView?pageNum=1" method="get">
			選擇月份: <select name='createMonth'>
				<option value='2020-01'>1月</option>
				<option value='2020-02'>2月</option>
				<option value='2020-03'>3月</option>
				<option value='2020-04'>4月</option>
				<option value='2020-05'>5月</option>
				<option value='2020-06'>6月</option>
				<option value='2020-07'>7月</option>
				<option value='2020-08'>8月</option>
				<option value='2020-09'>9月</option>
				<option value='2020-10'>10月</option>
				<option value='2020-11'>11月</option>
				<option value='2020-12'>12月</option>
			</select> <input type='hidden' name='pageNum' value='${page.currentPage}'>
			<input class="btn btn-primary" type="submit" value='查詢'>
		</form>
	</div>
	<br>
	<div style="font-size: 20px">共 ${page.totalNum}筆</div>

	<table border="1" class="table table-striped">
		<tr style="text-align: center">
			<td>預約人</td>
			<td>品種</td>
			<td>預約時間</td>
			<td>服務</td>
			<td>需求</td>
			<td>金額</td>
			<td>狀態</td>
			<td>評分</td>
			<td>評論</td>
			<c:forEach varStatus="star" var="View" items="${page.records}"
				begin='0' end='${page.pageSize-1}'>
				<tr style="text-align: center">
					<td>${View.username}</td>
					<td>${View.breed}</td>
					<td>${View.createDate}<br>${View.availableDateTime}:00</td>
					<td>${View.serviceItem}</td>
					<td>${View.require}</td>
					<td>${View.amount}</td>
					<td>${View.statuss}</td>
					<td>${View.score}</td>
					<td>${View.content}</td>
				</tr>
			</c:forEach>
		</tr>
	</table>

	<form method="get" action="pageBackView"
		style='float: left; margin-right: 10px'>
		<td><input type='hidden' name='pageNum'
			value='${page.currentPage-1}'> <input class="btn btn-success"
			type='submit' value='上一頁'></td>
	</form>

	<span style='float: left; margin-right: 10px; margin-top: 10px'>第
		${page.currentPage} 頁 , 共 ${page.totalPages}頁</span>

	<form method="get" action="pageBackView">
		<td><input type='hidden' name='pageNum'
			value='${page.currentPage+1}'> <input class="btn btn-success"
			type='submit' value='下一頁'></td>
	</form>



</body>

</html>