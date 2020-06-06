<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<meta charset="UTF-8">
<title>Happy Tail</title>
<!-- CSS  -->
<link href="<c:url value='/css/style.css'/>" type="text/css"
	rel="stylesheet" media="screen,projection" />
<!--Import Google Icon Font-->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!--Let browser know website is optimized for mobile-->
<!--jQuery-->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>
<!--JavaScript at end of body for optimized loading-->
<!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<script>
	$(document).ready(function() {
		$('.slider').slider({
			// 不顯示操控圓鈕
			indicators : false,
			// 每張照片播五秒
			interval : 2000
		})
	})
</script>
<body>
<%-- 	<%@ include file="top.jsp"%> --%>
	<jsp:include page="/top.jsp"></jsp:include>
	<div class="slider">
		<ul class="slides">
			<li><img src="<c:url value='/img/first.jpg'/>" /> <!--         <img src="image/first.jpg"> -->
				<div class="caption left-align grey-text text-lighten-5">
					<h1 style="text-align: center;">
						Caring for <br>Your Furry <br>Friends
					</h1>
				</div></li>
			<li><img src="<c:url value='/img/second.jpg'/>" /> <!--         <img src="image/second.jpg"> -->
				<div class="caption center-align grey-text text-lighten-4">
					<h1 style="text-align: center;">
						Caring for <br>Your Furry <br>Friends
					</h1>
				</div></li>
			<li><img src="<c:url value='/img/third.jpg'/>" /> <!-- 			<li><img src="image/third.jpg"> -->
				<div class="caption right-align grey-text text-lighten-4">
					<h1 style="text-align: center;">
						Caring for <br>Your Furry <br>Friends
					</h1>
				</div></li>
		</ul>
	</div>
	
	
	
	
	<%@ include file="footer.jsp"%>

</body>

</html>